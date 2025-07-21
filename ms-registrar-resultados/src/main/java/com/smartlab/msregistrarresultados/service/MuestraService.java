package com.smartlab.msregistrarresultados.service;

import java.util.List;

import com.smartlab.msregistrarresultados.aggregates.dto.MuestraDto;
import com.smartlab.msregistrarresultados.aggregates.request.RequestMuestra;
import com.smartlab.msregistrarresultados.entity.MuestraEntity;

public interface MuestraService {
    public MuestraDto registrarResultados(RequestMuestra requestMuestra, String username);
    List<MuestraEntity> listarMuestras();
}
