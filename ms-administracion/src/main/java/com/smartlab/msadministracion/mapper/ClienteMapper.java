package com.smartlab.msadministracion.mapper;

import com.smartlab.msadministracion.aggregates.dto.ClienteDto;
import com.smartlab.msadministracion.entity.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public ClienteDto mapToDto(ClienteEntity entity){
        return modelMapper.map(entity, ClienteDto.class);
    }
}
