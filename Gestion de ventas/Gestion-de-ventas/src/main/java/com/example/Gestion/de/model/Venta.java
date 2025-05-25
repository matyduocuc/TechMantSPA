package com.example.Gestion.de.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="ventas")
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(nullable = false)
    private Date fecha;

    @Column(name = "monto_total", precision = 10, scale = 2, nullable = false)
    private BigDecimal montoTotal;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario; // Cambiado a Long

    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @Column(name = "id_repuesto", nullable = false)
    private Integer idRepuesto;

}
