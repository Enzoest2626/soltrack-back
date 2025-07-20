package com.smartlab.msadministracion.service;

import com.smartlab.msadministracion.aggregates.dto.LubricanteDto;
import com.smartlab.msadministracion.aggregates.request.RequestLubricante;

import java.util.List;

public interface LubricanteService {
    LubricanteDto crearLubricante(RequestLubricante requestLubricante, String username);
    List<LubricanteDto> obtenerTodos();
}
