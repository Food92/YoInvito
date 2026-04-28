package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.exceptions.ClienteException;
import com.YoInvito.YoInvito.models.Cliente;
import com.YoInvito.YoInvito.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public Cliente findById(Long id) {
        return null;
    }

    @Override
    public Cliente findByRun(String run) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        return null;
    }
}
