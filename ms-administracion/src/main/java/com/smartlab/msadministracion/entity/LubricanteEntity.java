package com.smartlab.msadministracion.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "lubricante")
@Data
public class LubricanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lubricante")
    private Long idLub;
    @Column(name = "nombre_lub", nullable = false, length = 200)
    private String nombreLub;
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
