package com.YoInvito.YoInvito.repositories;

import com.YoInvito.YoInvito.models.Producto;
import com.YoInvito.YoInvito.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}