package com.smartlab.msregistrarresultados.service.impl;

import com.smartlab.msregistrarresultados.aggregates.constants.Constants;
import com.smartlab.msregistrarresultados.aggregates.dto.LubricanteDto;
import com.smartlab.msregistrarresultados.aggregates.request.RequestLubricante;
import com.smartlab.msregistrarresultados.entity.LubricanteEntity;
import com.smartlab.msregistrarresultados.repository.LubricanteRepository;
import com.smartlab.msregistrarresultados.service.LubricanteService;
import com.smartlab.msregistrarresultados.service.mappers.LubricanteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class LubricanteServiceImpl implements LubricanteService {

    private final LubricanteRepository lubricanteRepository;
    private final LubricanteMapper lubricanteMapper;
    @Override
    public LubricanteDto registrarLubricante(RequestLubricante requestLubricante) {
        lubricanteRepository.save(getEntity(requestLubricante));
        return lubricanteMapper.mapToDto(getEntity(requestLubricante));
    }

    private LubricanteEntity getEntity(RequestLubricante lubricante) {

        LubricanteEntity entity = new LubricanteEntity();
        entity.setNombreLub(lubricante.getNombreLub());
        entity.setEstado(Constants.STATUS_ACTIVE);
        entity.setUsuaCrea(Constants.AUDIT_ADMIN);
        entity.setDateCreate(getTimestamp());
        return entity;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}
