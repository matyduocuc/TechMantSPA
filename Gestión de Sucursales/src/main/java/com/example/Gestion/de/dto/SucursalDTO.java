package com.example.Gestion.de.dto;

import lombok.Data;

@Data
public class SucursalDTO {
    private Long sucursalId;
    private String nombre;
    private String direccion;
    private String telefono;
    private Long responsableId; // ID del responsable
    private Integer activa; // Estado de la sucursal
}
