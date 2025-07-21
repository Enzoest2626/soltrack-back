package com.smartlab.msregistrarresultados.service.mappers;


import com.smartlab.msregistrarresultados.aggregates.dto.MuestraDto;
import com.smartlab.msregistrarresultados.entity.MuestraEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MuestraMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public MuestraDto mapToDto(MuestraEntity entity){
        return modelMapper.map(entity, MuestraDto.class);
    }
}

