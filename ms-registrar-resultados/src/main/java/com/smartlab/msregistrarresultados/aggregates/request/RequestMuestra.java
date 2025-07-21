package com.smartlab.msregistrarresultados.aggregates.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RequestMuestra {
    private Long idMuestra;
    private Double viscosidad;
    private Double oxidacion;
    private Double nitracion;
    private Double agua;
}
