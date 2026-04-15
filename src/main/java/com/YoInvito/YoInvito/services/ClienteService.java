package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.models.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente>findAll();
    Cliente findById(Long id);
    Cliente findByRun(String run);
    Cliente save(Cliente cliente);
    void delete(Long id);
    Cliente update(Long id, Cliente cliente);
}
