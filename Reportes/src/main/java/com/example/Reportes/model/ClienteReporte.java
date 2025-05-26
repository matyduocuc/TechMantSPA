package com.example.Reportes.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes_reportes") // Define el nombre de la tabla en la base de datos
public class ClienteReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String email;
}