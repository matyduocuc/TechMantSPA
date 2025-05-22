package com.example.Facturacion.y.Pagos.service;

import com.example.Facturacion.y.Pagos.model.EstadoFactura;
import com.example.Facturacion.y.Pagos.model.Factura;
import com.example.Facturacion.y.Pagos.model.MetodoPago;
import com.example.Facturacion.y.Pagos.model.Pago;
import com.example.Facturacion.y.Pagos.repository.EstadoFacturaRepository;
import com.example.Facturacion.y.Pagos.repository.FacturaRepository;
import com.example.Facturacion.y.Pagos.repository.MetodoPagoRepository;
import com.example.Facturacion.y.Pagos.repository.PagoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagoService {
    private final PagoRepository pagoRepo;
    private final FacturaRepository facturaRepo;
    private final MetodoPagoRepository metodoRepo;
    private final EstadoFacturaRepository estadoRepo;

    @Transactional
    public Pago registrarPago(Long metodoId, Double monto, String referencia, Long facturaId) {
        // Validaciones básicas
        if (monto == null || monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }

        MetodoPago metodo = metodoRepo.findById(metodoId)
            .orElseThrow(() -> new NoSuchElementException("Método de pago no encontrado con ID: " + metodoId));

        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setFecha(LocalDateTime.now());
        pago.setMetodoPago(metodo);
        pago.setReferencia(referencia != null ? referencia : "REF-" + UUID.randomUUID().toString().substring(0, 8));

        // Asociar factura si se proporciona facturaId
        if (facturaId != null) {
            Factura factura = facturaRepo.findById(facturaId)
                .orElseThrow(() -> new NoSuchElementException("Factura no encontrada con ID: " + facturaId));
            
            validarPagoContraFactura(factura, monto);
            pago.setFactura(factura);
            
            // Actualizar estado si el pago completa el total
            if (calcularSaldoPendiente(factura.getId()) <= 0) {
                actualizarEstadoFactura(factura, "PAGADA");
            }
        }

        return pagoRepo.save(pago);
    }

    @Transactional
    public Pago asociarPagoAFactura(Long pagoId, Long facturaId) {
        Pago pago = pagoRepo.findById(pagoId)
            .orElseThrow(() -> new NoSuchElementException("Pago no encontrado con ID: " + pagoId));

        if (pago.getFactura() != null) {
            throw new IllegalStateException("El pago ya está asociado a la factura: " + pago.getFactura().getId());
        }

        Factura factura = facturaRepo.findById(facturaId)
            .orElseThrow(() -> new NoSuchElementException("Factura no encontrada con ID: " + facturaId));

        validarPagoContraFactura(factura, pago.getMonto());
        pago.setFactura(factura);

        // Actualizar estado si el pago completa el total
        if (calcularSaldoPendiente(factura.getId()) <= 0) {
            actualizarEstadoFactura(factura, "PAGADA");
        }

        return pagoRepo.save(pago);
    }

    public List<Pago> listarPagosPorFactura(Long facturaId) {
        return pagoRepo.findByFacturaId(facturaId);
    }

    public List<Pago> listarPagosSinFactura() {
        return pagoRepo.findByFacturaIsNull();
    }

    public Double calcularSaldoPendiente(Long facturaId) {
        Factura factura = facturaRepo.findById(facturaId)
            .orElseThrow(() -> new NoSuchElementException("Factura no encontrada"));
        
        Double totalPagado = pagoRepo.sumMontoByFacturaId(facturaId).orElse(0.0);
        return factura.getTotal() - totalPagado;
    }

    private void validarPagoContraFactura(Factura factura, Double monto) {
        Double saldoPendiente = calcularSaldoPendiente(factura.getId());
        
        if (monto > saldoPendiente) {
            throw new IllegalStateException(String.format(
                "Monto excede el saldo pendiente. Saldo: %.2f, Pago: %.2f", 
                saldoPendiente, monto
            ));
        }
    }

    private void actualizarEstadoFactura(Factura factura, String estadoNombre) {
        EstadoFactura estado = estadoRepo.findByNombre(estadoNombre)
            .orElseThrow(() -> new IllegalStateException("Estado no encontrado: " + estadoNombre));
        
        factura.setEstado(estado);
        facturaRepo.save(factura);
        log.info("Factura {} actualizada a estado: {}", factura.getId(), estadoNombre);
    }

    public Pago obtenerPagoPorId(Long pagoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPagoPorId'");
    }
}