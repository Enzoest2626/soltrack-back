package com.smartlab.msadministracion.service;

import com.smartlab.msadministracion.aggregates.dto.ClienteDto;
import com.smartlab.msadministracion.aggregates.request.RequestCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ClienteDto crearCliente(RequestCliente requestCliente, String username);

    Optional<ClienteDto> obtenerCliente(Long id);

    List<ClienteDto> obtenerTodos();
}
