package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.exceptions.ClienteException;
import com.YoInvito.YoInvito.models.Cliente;
import com.YoInvito.YoInvito.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cliente findById(Long id){
        return this.clienteRepository.findById(id).orElseThrow(()-> new ClienteException("Cliente no se encuentra"));
    }

    @Transactional(readOnly = true)
    public Cliente findByRun(String run){
        return this.clienteRepository.findByRun(run).orElseThrow(()-> new ClienteException("Cliente con este run no se encuentra"));
    }

    @Transactional
    public Cliente save(Cliente cliente){
        if(this.clienteRepository.findByRun(cliente.getRun()).isPresent()){
            throw new ClienteException("Cliente existente");}
            return this.clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(Long id){
        this.clienteRepository.deleteById(id);
    }

}
