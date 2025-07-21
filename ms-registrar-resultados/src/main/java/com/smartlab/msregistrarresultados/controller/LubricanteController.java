package com.smartlab.msregistrarresultados.controller;

import com.smartlab.msregistrarresultados.aggregates.dto.LubricanteDto;
import com.smartlab.msregistrarresultados.aggregates.request.RequestLubricante;
import com.smartlab.msregistrarresultados.service.LubricanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/lubricantes")
public class LubricanteController {
    private final LubricanteService lubricanteService;

    @PostMapping
    public ResponseEntity<LubricanteDto> registrarLubricante(@RequestBody RequestLubricante lubricante){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lubricanteService.registrarLubricante(lubricante));
    }




}
