package com.example.gestion.de.tareas.automatizadas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    private boolean completada = false; // Indica si la tarea está completada

    @Column(name = "id_tecnico") // Campo para el ID técnico
    private Long idTecnico;

    // Constructor adicional para asignar todos los campos
    public Tarea(String nombre, String descripcion, Long idTecnico) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTecnico = idTecnico;
    }
}