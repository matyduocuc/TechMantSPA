package com.example.gestion.de.tareas.automatizadas.dto;

import lombok.Data;

@Data
public class TareaDTO {
    private String nombre;
    private String descripcion;
    private Long idTecnico;
}
