package com.smartlab.msadministracion.controller;

import com.smartlab.msadministracion.aggregates.dto.LubricanteDto;
import com.smartlab.msadministracion.aggregates.request.RequestLubricante;
import com.smartlab.msadministracion.service.LubricanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lubricantes")
public class LubricanteController {
    private final LubricanteService lubricanteService;

    @PostMapping("/crear")
    public ResponseEntity<LubricanteDto> crearLubricante(@RequestBody RequestLubricante requestLubricante,
                                                         @RequestHeader("loggedInUser") String username){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lubricanteService.crearLubricante(requestLubricante, username));
    }
}
