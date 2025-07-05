package com.smartlab.msadministracion.repository;

import com.smartlab.msadministracion.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    List<ClienteEntity> findByEstado(Integer Estado);
}
