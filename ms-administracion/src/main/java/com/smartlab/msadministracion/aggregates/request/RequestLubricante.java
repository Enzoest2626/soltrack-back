package com.smartlab.msadministracion.aggregates.request;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestLubricante {
    private String nombreLub;
    private String codigoLub;
    private String fabricante;
    private String tipoLubricante;
    private String viscosidad;
    private BigDecimal densidad;
    private BigDecimal puntoIgnicion;
    private String recomendaciones;
    private String observaciones;
}
