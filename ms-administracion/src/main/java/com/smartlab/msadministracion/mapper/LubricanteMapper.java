package com.smartlab.msadministracion.mapper;

import com.smartlab.msadministracion.aggregates.dto.LubricanteDto;
import com.smartlab.msadministracion.entity.LubricanteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LubricanteMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public LubricanteDto mapToDto(LubricanteEntity entity){
        return modelMapper.map(entity, LubricanteDto.class);
    }
}
