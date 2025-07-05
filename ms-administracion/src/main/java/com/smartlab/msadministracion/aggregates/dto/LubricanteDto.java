package com.smartlab.msadministracion.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LubricanteDto {
    private Long idLub;
    private String nombreLub;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
