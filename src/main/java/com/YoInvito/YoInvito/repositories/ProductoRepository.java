package com.YoInvito.YoInvito.repositories;

import com.YoInvito.YoInvito.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
