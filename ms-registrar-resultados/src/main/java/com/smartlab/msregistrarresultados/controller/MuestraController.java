package com.smartlab.msregistrarresultados.controller;

import com.smartlab.msregistrarresultados.aggregates.request.RequestMuestra;
import com.smartlab.msregistrarresultados.service.MuestraService;
import com.smartlab.msregistrarresultados.service.impl.MuestraServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resultados")
@RequiredArgsConstructor
public class MuestraController {

    private final MuestraService muestraService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarResultadoMuestra(@RequestBody RequestMuestra requestMuestra,
                                              @RequestHeader("loggedInUser") String username){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(muestraService.registrarResultados(requestMuestra,username));
        } catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Muestra incorrecto");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarMuestras(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(muestraService.listarMuestras());
        } catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener muestras");
        }
    }
}
