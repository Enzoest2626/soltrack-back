package com.codigo.mslogin.repository;

import com.codigo.mslogin.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    ClienteEntity findByRazonSocial(String razonSocial);
    List<ClienteEntity> findByEstado(Integer Estado);
}
