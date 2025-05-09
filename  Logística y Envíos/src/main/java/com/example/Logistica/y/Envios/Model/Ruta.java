package com.example.Logistica.y.Envios.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rutas")
@Data
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private Double distanciaKm;

    @Column(nullable = false)
    private Integer tiempoEstimadoMin;

    @ManyToOne
    @JoinColumn(name = "id_envio", nullable = false)
    private Envio envio;
}
