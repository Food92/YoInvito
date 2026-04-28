package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.Producto;
import com.YoInvito.YoInvito.models.Restaurant;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    List<Producto> findByName(String name);
    List<Producto> findByRestaurant(Restaurant restaurant);
    Producto update(Long id, Producto producto);
    Producto save(Producto producto);
    Producto delete(Long id);
}
