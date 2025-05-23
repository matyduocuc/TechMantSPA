package com.example.Gestion.de.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipoId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Set<Sucursal> sucursalEquipos;
}