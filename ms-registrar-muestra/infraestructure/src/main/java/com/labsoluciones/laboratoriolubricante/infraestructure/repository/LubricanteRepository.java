package com.labsoluciones.laboratoriolubricante.infraestructure.repository;

import com.labsoluciones.laboratoriolubricante.infraestructure.entity.LubricanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LubricanteRepository extends JpaRepository<LubricanteEntity, Long> {
}
