package com.smartlab.msadministracion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "ruc", nullable = false, length = 15)
    private String ruc;
    @Column(name = "razon_social", nullable = false, length = 200)
    private String razonSocial;
    @Column(name = "nombre_comercial", length = 50)
    private String nombreComercial;
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
