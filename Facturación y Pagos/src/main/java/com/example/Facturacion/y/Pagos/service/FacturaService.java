package com.example.Facturacion.y.Pagos.service;


import com.example.Facturacion.y.Pagos.model.EstadoFactura;
import com.example.Facturacion.y.Pagos.model.Factura;
import com.example.Facturacion.y.Pagos.model.Pago;
import com.example.Facturacion.y.Pagos.repository.EstadoFacturaRepository;
import com.example.Facturacion.y.Pagos.repository.FacturaRepository;
import com.example.Facturacion.y.Pagos.repository.PagoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacturaService {
    private final FacturaRepository facturaRepo;
    private final EstadoFacturaRepository estadoRepo;
    private final PagoRepository pagoRepo;

    @Transactional
    public Factura crearFactura(Factura factura, Long pagoId) {
        // Validaciones básicas
        if (factura.getSubtotal() == null || factura.getIva() == null) {
            throw new IllegalArgumentException("Subtotal e IVA son obligatorios");
        }

        double total = factura.getSubtotal() + factura.getIva();
        if (total <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a cero");
        }

        // Buscar pago existente si se proporciona pagoId
        Pago pagoAsociado = null;
        if (pagoId != null) {
            pagoAsociado = pagoRepo.findById(pagoId)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado con ID: " + pagoId));
            
            if (pagoAsociado.getFactura() != null) {
                throw new IllegalStateException("El pago ya está asociado a otra factura");
            }

            if (Math.abs(pagoAsociado.getMonto() - total) > 0.01) {
                throw new IllegalArgumentException("El monto del pago no coincide con el total de la factura");
            }
        }

        // Obtener el estado "PENDIENTE"
        EstadoFactura estado = estadoRepo.findByNombre("PENDIENTE")
            .orElseThrow(() -> new IllegalStateException("Estado PENDIENTE no configurado en el sistema"));

        // Crear factura
        factura.setNumero(generarNumeroFactura());
        factura.setEstado(estado);
        factura.setFechaEmision(LocalDateTime.now());
        factura.setFechaVencimiento(LocalDateTime.now().plusDays(15));
        factura.setTotal(total);
        
        Factura facturaCreada = facturaRepo.save(factura);

        // Asociar pago si existe
        if (pagoAsociado != null) {
            pagoAsociado.setFactura(facturaCreada);
            pagoRepo.save(pagoAsociado);
            log.info("Pago {} asociado a factura {}", pagoId, facturaCreada.getId());
        }

        return facturaCreada;
    }

    public Optional<Factura> buscarPorId(Long id) {
        return facturaRepo.findById(id);
    }

    public List<Factura> buscarFacturasSinPago() {
        return facturaRepo.findByPagosIsEmpty();
    }

    private String generarNumeroFactura() {
        String prefix = "FAC-" + LocalDateTime.now().getYear() + "-";
        Long secuencia = facturaRepo.count() + 1;
        return prefix + String.format("%05d", secuencia);
    }
}