package com.YoInvito.YoInvito.services;

import com.YoInvito.YoInvito.exceptions.ClienteException;
import com.YoInvito.YoInvito.models.Cliente;
import com.YoInvito.YoInvito.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl {
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return this.clienteRepository.findById(id).orElseThrow(()-> new ClienteException("Cliente no se encuentra"));
    }

    public Cliente findByRun(String run){
        return this.clienteRepository.findByRun(run).orElseThrow(()-> new ClienteException("Cliente con este run no se encuentra"));
    }

    public Cliente save(Cliente cliente){
        if(this.clienteRepository.findByRun(cliente.getRun()).isPresent()){
            throw new ClienteException("Cliente existente");}
            return this.clienteRepository.save(cliente);
    }

    public void deleteById(Long id){
        this.clienteRepository.deleteById(id);
    }

}
