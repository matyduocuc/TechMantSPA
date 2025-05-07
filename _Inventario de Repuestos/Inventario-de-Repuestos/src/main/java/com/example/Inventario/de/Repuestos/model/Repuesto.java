package com.example.Inventario.de.Repuestos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "repuestos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repuesto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepuesto;

    @Column(length = 50, nullable = false, unique = true)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String categoria;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "stock_minimo", nullable = false)
    private Integer stockMinimo;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
}