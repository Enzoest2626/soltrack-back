package com.smartlab.msregistrarresultados.service;

import com.smartlab.msregistrarresultados.aggregates.dto.LubricanteDto;
import com.smartlab.msregistrarresultados.aggregates.request.RequestLubricante;
import com.smartlab.msregistrarresultados.entity.LubricanteEntity;

public interface LubricanteService {
    LubricanteDto registrarLubricante(RequestLubricante requestLubricante);
}
