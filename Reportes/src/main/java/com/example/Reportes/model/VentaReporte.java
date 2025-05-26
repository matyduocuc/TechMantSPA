package com.example.Reportes.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas_reportes") // Define el nombre de la tabla en la base de datos
public class VentaReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    private String fecha;
    private Double montoTotal;
    private String nombreCliente;
}