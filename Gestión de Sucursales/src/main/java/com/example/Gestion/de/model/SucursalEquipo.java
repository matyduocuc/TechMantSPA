package com.example.Gestion.de.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "sucursal_equipos")
@IdClass(Sucursal.class)
public class SucursalEquipo {

    @Id
    private Long sucursalId;

    @Id
    private Long equipoId;

    @Column(name = "fecha_asignacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", insertable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = false, updatable = false)
    private Equipo equipo;

    // Getters y Setters
}