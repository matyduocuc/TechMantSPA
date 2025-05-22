package com.example.Facturacion.y.Pagos.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Facturacion.y.Pagos.WebClient.UsuarioClient;
import com.example.Facturacion.y.Pagos.model.Pago;
import com.example.Facturacion.y.Pagos.model.Usuario;
import com.example.Facturacion.y.Pagos.service.PagoService;
import com.example.Facturacion.y.Pagos.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService pagoService;
    private final UsuarioService usuarioService; // Inyectar UsuarioService

    @PostMapping
    public ResponseEntity<Pago> registrarPago(
            @RequestParam Long metodoId,
            @RequestParam Double monto,
            @RequestParam(required = false) String referencia,
            @RequestParam(required = false) Long facturaId) {
        Pago pago = pagoService.registrarPago(metodoId, monto, referencia, facturaId);
        return ResponseEntity.ok(pago);
    }

    @PostMapping("/{pagoId}/factura/{facturaId}")
    public ResponseEntity<Pago> asociarPagoAFactura(
            @PathVariable Long pagoId,
            @PathVariable Long facturaId) {
        Pago pago = pagoService.asociarPagoAFactura(pagoId, facturaId);
        return ResponseEntity.ok(pago);
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<Pago>> listarPagosPorFactura(@PathVariable Long facturaId) {
        List<Pago> pagos = pagoService.listarPagosPorFactura(facturaId);
        return ResponseEntity.ok(pagos);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagosSinFactura() {
        List<Pago> pagos = pagoService.listarPagosSinFactura();
        return ResponseEntity.ok(pagos);
    }

    // Nuevo método para obtener información del usuario asociado a un pago
    @GetMapping("/pago/{pagoId}/usuario")
    public ResponseEntity<Usuario> obtenerUsuarioPorPago(@PathVariable Long pagoId) {
        // Lógica para obtener el usuario asociado al pago
        // Asumimos que el Pago tiene un campo 'usuarioId' o similar
        Pago pago = pagoService.obtenerPagoPorId(pagoId);
        Usuario usuario = usuarioService.obtenerUsuario(pago.getUsuarioId()); // Método para obtener usuario
        return ResponseEntity.ok(usuario);
    }
}