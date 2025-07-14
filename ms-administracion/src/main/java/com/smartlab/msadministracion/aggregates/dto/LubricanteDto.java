package com.smartlab.msadministracion.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LubricanteDto {
    private Long idLub;
    private String nombreLub;
    private String codigoLub;
    private String fabricante;
    private String tipoLubricante;
    private String viscosidad;
    private BigDecimal densidad;
    private BigDecimal puntoIgnicion;
    private String recomendaciones;
    private String observaciones;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
