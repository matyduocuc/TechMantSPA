package com.example.Gestion.de.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "sucursales")
public class Sucursal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sucursalId;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 200)
    private String direccion;
    
    @Column(nullable = false, length = 20)
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name = "responsable_id", referencedColumnName = "usuario_id")
    private Usuario responsable;

    @Column(columnDefinition = "NUMBER(1) DEFAULT 1")
    private Integer activa;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private Set<Sucursal> sucursalEquipos;

    // Getters y Setters
}