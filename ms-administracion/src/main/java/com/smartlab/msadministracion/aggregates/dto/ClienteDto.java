package com.smartlab.msadministracion.aggregates.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ClienteDto {
    private Long idCliente;
    private String ruc;
    private String razonSocial;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
