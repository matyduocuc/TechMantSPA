package com.example.Facturacion.y.Pagos.model;

import lombok.Data;

@Data
public class Usuario {
    private Long id;              // ID del usuario
    private String username;      // Nombre de usuario
    private String password;      // Contraseña
    private String email;         // Correo electrónico (opcional)
    // Otros campos según sea necesario
}
