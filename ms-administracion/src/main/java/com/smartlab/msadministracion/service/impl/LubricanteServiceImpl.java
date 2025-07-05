package com.smartlab.msadministracion.service.impl;

import com.smartlab.msadministracion.aggregates.dto.LubricanteDto;
import com.smartlab.msadministracion.aggregates.request.RequestLubricante;
import com.smartlab.msadministracion.entity.LubricanteEntity;
import com.smartlab.msadministracion.entity.UsuarioEntity;
import com.smartlab.msadministracion.mapper.LubricanteMapper;
import com.smartlab.msadministracion.repository.LubricanteRepository;
import com.smartlab.msadministracion.repository.UsuarioRepository;
import com.smartlab.msadministracion.service.LubricanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LubricanteServiceImpl implements LubricanteService {
    private final LubricanteRepository lubricanteRepository;
    private final UsuarioRepository usuarioRepository;
    private final LubricanteMapper lubricanteMapper;

    @Override
    public LubricanteDto crearLubricante(RequestLubricante requestLubricante, String username) {
        LubricanteEntity lubricanteCreado = obtenerLubricanteCreado(requestLubricante, username);
        lubricanteRepository.save(lubricanteCreado);
        return lubricanteMapper.mapToDto(lubricanteCreado);
    }

    private LubricanteEntity obtenerLubricanteCreado(RequestLubricante requestLubricante, String username){
        LubricanteEntity lubricante = new LubricanteEntity();
        lubricante.setNombreLub(requestLubricante.getNombreLub());
        lubricante.setEstado(1);
        lubricante.setUsuaCrea(obtenerUsuario(username).getIdUsuario().toString());
        lubricante.setDateCreate(getTimestamp());
        return lubricante;
    }

    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }

    private UsuarioEntity obtenerUsuario(String username){
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new NoSuchElementException("El usuario no existe"));
    }
}
