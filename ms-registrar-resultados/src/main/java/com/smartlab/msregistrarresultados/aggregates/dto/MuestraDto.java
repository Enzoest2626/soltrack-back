package com.smartlab.msregistrarresultados.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MuestraDto {
    private Long idMuestra;
    private Integer estado;
    private Double viscosidad;
    private Double oxidacion;
    private Double nitracion;
    private Double agua;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
    private Long solicitudId;
    private Integer lubricante;
}
