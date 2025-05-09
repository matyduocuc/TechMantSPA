package com.example.Logistica.y.Envios.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;

    @Column(nullable = false)
    private String codigoSeguimiento;

    @Column(nullable = false)
    private String direccionOrigen;

    @Column(nullable = false)
    private String direccionDestino;

    @Column(nullable = false)
    private String estado; // "PREPARACION", "EN_TRANSITO", "ENTREGADO"

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = true)
    private LocalDateTime fechaEntrega;

    @Column(nullable = false)
    private Double pesoKg;

    @Column(nullable = false)
    private String transportista;
}
