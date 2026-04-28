package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido>findAll();
    Pedido findById(Long id);
    Pedido save(Pedido pedido);
    Pedido update(Pedido pedido);
    void delete(Pedido pedido);
}
