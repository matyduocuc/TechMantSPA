package com.example.Gestion.de.ventas.model;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(nullable = false)
    private Date fecha;

    @Column(name = "monto_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @Column(name = "id_repuesto", nullable = false)
    private Integer idRepuesto;
}