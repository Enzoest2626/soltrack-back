package com.smartlab.msregistrarresultados.service.mappers;

import com.smartlab.msregistrarresultados.aggregates.dto.LubricanteDto;
import com.smartlab.msregistrarresultados.entity.LubricanteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LubricanteMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public LubricanteDto mapToDto(LubricanteEntity entity){
        return modelMapper.map(entity, LubricanteDto.class);
    }
}
