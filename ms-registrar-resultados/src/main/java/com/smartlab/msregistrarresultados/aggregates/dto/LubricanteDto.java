package com.smartlab.msregistrarresultados.aggregates.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LubricanteDto {
    private Long idLubricante;
    private String nombreLub;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelete;
    private Timestamp dateDelete;
}
