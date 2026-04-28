package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.Producto;
import com.YoInvito.YoInvito.models.Restaurant;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto findById(Long id);
    Producto update(Long id, Producto producto);
    Producto save(Producto producto);
    void delete(Long id);
}
