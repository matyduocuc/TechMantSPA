package com.example.Automatizacion.de.Tareas.Repetitivas.dto;

import lombok.Data;

@Data
public class TareaDTO {
    private String nombre;
    private String descripcion;
    private Long idTecnico; // Agregado para el ID técnico
}