package com.example.Monitoreo.de.Equipos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "equipos")
@Data

public class Equipo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String serial;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String ubicacion;
    
    private Double temperatura;
    private Double humedad;
    private Boolean estado;
    
    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;
    
    @PrePersist
    @PreUpdate
    private void actualizarTimestamp() {
        this.ultimaActualizacion = LocalDateTime.now();
    }
}


