package com.example.Gestion.de.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long usuarioId;
    private String nombre;
    private String email;
    private String contraseña;
}
