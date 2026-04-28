package com.YoInvito.YoInvito.repositories;

import com.YoInvito.YoInvito.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
