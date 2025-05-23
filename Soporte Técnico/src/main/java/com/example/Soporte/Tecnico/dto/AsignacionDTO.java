package com.example.Soporte.Tecnico.dto;

import lombok.Data;

@Data
public class AsignacionDTO {
    private Long tecnicoId;  // ID del técnico
    private Long ticketId;    // ID del ticket
}
