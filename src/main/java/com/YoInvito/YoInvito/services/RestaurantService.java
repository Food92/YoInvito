package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();
    Restaurant findById(Long id);
    Restaurant save(Restaurant restaurant);
    Restaurant update(Long id,Restaurant restaurant);
    void delete(Long id);
}
