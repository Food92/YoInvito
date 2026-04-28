package com.YoInvito.YoInvito.repositories;

import com.YoInvito.YoInvito.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByRun(String run);

}
