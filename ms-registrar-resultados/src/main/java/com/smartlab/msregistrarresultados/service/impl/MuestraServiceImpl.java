package com.smartlab.msregistrarresultados.service.impl;

import com.smartlab.msregistrarresultados.aggregates.dto.MuestraDto;
import com.smartlab.msregistrarresultados.aggregates.request.RequestMuestra;
import com.smartlab.msregistrarresultados.entity.MuestraEntity;
import com.smartlab.msregistrarresultados.repository.MuestraRepository;
import com.smartlab.msregistrarresultados.repository.UsuarioRepository;
import com.smartlab.msregistrarresultados.service.MuestraService;
import com.smartlab.msregistrarresultados.service.mappers.MuestraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MuestraServiceImpl implements MuestraService {
    private final MuestraRepository muestraRepository;
    private final UsuarioRepository usuarioRepository;
    private final MuestraMapper muestraMapper;
    @Override
    public MuestraDto registrarResultados(RequestMuestra requestMuestra, String username) {
        MuestraEntity muestra = getEntity(requestMuestra, username);
        MuestraEntity muestraGuardada = muestraRepository.save(muestra);
        return muestraMapper.mapToDto(muestraGuardada);
    }

    private MuestraEntity getEntity(RequestMuestra requestMuestra, String username){
        MuestraEntity entity = muestraRepository.findById(requestMuestra.getIdMuestra())
                .orElseThrow(() -> new NoSuchElementException("Muestra " + requestMuestra.getIdMuestra() + " inválida"));
        entity.setViscosidad(requestMuestra.getViscosidad());
        entity.setOxidacion(requestMuestra.getOxidacion());
        entity.setNitracion(requestMuestra.getNitracion());
        entity.setAgua(requestMuestra.getAgua());
        entity.setEstado(2); //estado 2 implica que la muestra ha sido analizada
        entity.setUsuaModif(usuarioRepository.findByEmail(username).get().getIdUsuario().toString());
        return entity;
    }

    @Override
    public List<MuestraEntity> listarMuestras() {
        return muestraRepository.findAll();
    }
}
