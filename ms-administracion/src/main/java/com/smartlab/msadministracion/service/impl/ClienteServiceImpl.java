package com.smartlab.msadministracion.service.impl;

import com.smartlab.msadministracion.aggregates.constansts.Constants;
import com.smartlab.msadministracion.aggregates.dto.ClienteDto;
import com.smartlab.msadministracion.aggregates.request.RequestCliente;
import com.smartlab.msadministracion.aggregates.response.ResponseSunat;
import com.smartlab.msadministracion.entity.ClienteEntity;
import com.smartlab.msadministracion.entity.UsuarioEntity;
import com.smartlab.msadministracion.mapper.ClienteMapper;
import com.smartlab.msadministracion.redis.RedisService;
import com.smartlab.msadministracion.repository.ClienteRepository;
import com.smartlab.msadministracion.repository.UsuarioRepository;
import com.smartlab.msadministracion.rest.SunatClient;
import com.smartlab.msadministracion.service.ClienteService;
import com.smartlab.msadministracion.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final SunatClient sunatClient;
    private final UsuarioRepository usuarioRepository;
    private final RedisService redisService;
    private final Util util;

    @Value("${token.api}")
    private String tokenApi;

    @Override
    public ClienteDto crearCliente(RequestCliente requestCliente, String username) {
        validations(requestCliente);
        ResponseSunat datosSunat = getExecutionSunat(requestCliente.getRuc());
        ClienteEntity clienteGuardado = clienteRepository.save(getEntity(datosSunat, requestCliente, username));
        return clienteMapper.mapToDto(clienteGuardado);
    }

    private void validations(RequestCliente requestCliente) {
        Optional<ClienteEntity> entity = clienteRepository.findByRuc(requestCliente.getRuc());

        if (entity.isPresent()) {
            throw new RuntimeException("El RUC ya se encuentra registrado");
        }
    }

    @Override
    public Optional<ClienteDto> obtenerCliente(Long id) {
        String redisInfo = redisService.getFromRedis(Constants.REDIS_KEY_PERSONA+id);
        if (redisInfo != null) {
            ClienteDto clienteDTO = util.convertFromJson(redisInfo, ClienteDto.class);
            return Optional.of(clienteDTO);
        } else {
            ClienteDto dto = clienteMapper.mapToDto(clienteRepository.findById(id).get());
            String redis = util.convertToJson(dto);
            redisService.saveInRedis(Constants.REDIS_KEY_PERSONA+id,redis,1);
            return Optional.of(dto);
        }
    }

    @Override
    public List<ClienteDto> obtenerTodos() {
        List<ClienteDto> clienteDtoList = new ArrayList<>();
        List<ClienteEntity> entities = clienteRepository.findAll();
        List<Long> idsUsuarios = entities.stream().map(ClienteEntity::getIdCliente).toList();
        List<UsuarioEntity> usuarios = usuarioRepository.findAllById(idsUsuarios);

        for(ClienteEntity clienteEntity:entities) {
            ClienteDto clienteDTO = clienteMapper.mapToDto(clienteEntity);
            usuarios.stream()
                    .filter(u -> u.getIdUsuario().toString().equals(clienteEntity.getUsuaCrea()))
                    .findFirst().
                    ifPresent(u -> {;
                        clienteDTO.setUsuaCrea(u.getNombres());
                    });
            clienteDtoList.add(clienteDTO);
        }
        return clienteDtoList;
    }

    @Override
    public ClienteDto obtenerPorRuc(String ruc) {
        return mapToDtoBySunat(getExecutionSunat(ruc));
    }


    private ClienteEntity getEntity(ResponseSunat sunat,
                                    RequestCliente requestCliente,
                                    String username){
        UsuarioEntity usuario = obtenerUsuario(username);
        ClienteEntity entity = new ClienteEntity();
        entity.setRuc(sunat.getNumeroDocumento());
        entity.setRazonSocial(sunat.getRazonSocial());
        entity.setNombreComercial(requestCliente.getNombreComercial());
        entity.setEstado(1);
        entity.setUsuaCrea(usuario.getIdUsuario().toString());
        entity.setDateCreate(getTimestamp());
        return entity;

    }

    private ClienteDto mapToDtoBySunat(ResponseSunat sunat) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setRuc(sunat.getNumeroDocumento());
        clienteDto.setRazonSocial(sunat.getRazonSocial());
        return clienteDto;
    }


    public ResponseSunat getExecutionSunat(String numero){
        String authorization = "Bearer " + tokenApi;
        ResponseSunat responseSunat = sunatClient.getInfo(numero, authorization);
        return responseSunat;
    }

    private UsuarioEntity obtenerUsuario(String username){
        return usuarioRepository.findByEmail(username).get();
    }
    private Timestamp getTimestamp(){
        long currentTime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTime);
        return timestamp;
    }
}
