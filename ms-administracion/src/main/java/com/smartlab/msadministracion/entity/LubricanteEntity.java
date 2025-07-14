package com.smartlab.msadministracion.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "lubricante")
@Data
public class LubricanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lubricante")
    private Long idLub;
    @Column(name = "nombre_lub")
    private String nombreLub;

    @Column(name = "codigo_lub")
    private String codigoLub;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "tipo_lubricante")
    private String tipoLubricante;

    @Column(name = "viscosidad")
    private String viscosidad;

    @Column(name = "densidad")
    private BigDecimal densidad;;

    @Column(name = "punto_ignicion")
    private BigDecimal puntoIgnicion;

    @Column(name = "recomendaciones")
    private String recomendaciones;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estado", nullable = false)
    private Integer estado;
    @Column(name = "usua_create", length = 45)
    private String usuaCrea;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usua_modif", length = 45)
    private String usuaModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "usua_delete", length = 45)
    private String usuaDelet;
    @Column(name = "date_delete")
    private Timestamp dateDelet;
}
