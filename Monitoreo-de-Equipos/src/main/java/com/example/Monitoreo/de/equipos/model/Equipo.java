package com.example.Monitoreo.de.equipos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "id_modelo")
    private Long idModelo;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "id_usuario") // Nuevo campo para el ID del usuario
    private Long idUsuario;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;
}