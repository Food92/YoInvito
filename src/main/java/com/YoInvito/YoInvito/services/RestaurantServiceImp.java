package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.exceptions.RestaurantException;
import com.YoInvito.YoInvito.models.Restaurant;
import com.YoInvito.YoInvito.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Restaurant> findAll() {
        return this.restaurantRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Restaurant findById(Long id) {
        return this.restaurantRepository.findById(id).orElseThrow(
                ()-> new RestaurantException("Restaurant con id"+ id + "no se encontrado"));
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        if(this.restaurantRepository.findById(restaurant.getIdRestaurant()).isPresent()) {
            throw new RestaurantException("Ya existe un restaurant con ID:"+ restaurant.getIdRestaurant());
        }
        Restaurant newRestaurant= new Restaurant();
        newRestaurant.setNombreRestaurant(restaurant.getNombreRestaurant());
        newRestaurant.setCorreo(restaurant.getCorreo());
        newRestaurant.setDireccion(restaurant.getDireccion());
        newRestaurant.setTelephone(restaurant.getTelephone());
        newRestaurant.setCategoria(restaurant.getCategoria());
        return this.restaurantRepository.save(newRestaurant);
    }

    @Transactional
    @Override
    public Restaurant update(Long id,Restaurant restaurant) {
        return this.restaurantRepository.findById(id).map(updated -> {
            updated.setNombreRestaurant(restaurant.getNombreRestaurant());
            updated.setCorreo(restaurant.getCorreo());
            updated.setDireccion(restaurant.getDireccion());
            updated.setTelephone(restaurant.getTelephone());
            updated.setCategoria(restaurant.getCategoria());
            return this.restaurantRepository.save(updated);
        }).orElseThrow(
                () -> new RestaurantException("Restaurant con id" + id + "no existe")
        );
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.restaurantRepository.deleteById(id);

    }
}
