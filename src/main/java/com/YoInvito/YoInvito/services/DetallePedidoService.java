package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.DetallePedido;

import java.util.List;

public interface DetallePedidoService {
    List<DetallePedido> findByPedidoId(Long id);
    List<DetallePedido> findByProductoId(Long id);
    DetallePedido findById(Long id);
    DetallePedido save(DetallePedido detallePedido);
    DetallePedido update(DetallePedido detallePedido);
}
