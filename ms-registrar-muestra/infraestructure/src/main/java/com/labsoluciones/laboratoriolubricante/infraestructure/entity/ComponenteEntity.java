package com.labsoluciones.laboratoriolubricante.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "componente")
@Getter
@Setter
public class ComponenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componente")
    private Long idComponente;
    @Column(name = "nom_componente", nullable = false)
    private String nomComponente;
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

    // Relacion con equipo
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_equipo")
    private EquipoEntity equipo;
}
