package com.smartlab.msadministracion.repository;

import com.smartlab.msadministracion.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findByEstado(Integer Estado);

    Optional<ClienteEntity> findByRuc(String ruc);
}
