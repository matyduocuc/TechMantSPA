package com.example.Reportes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.Reportes.model.VentaReporte;
import com.example.Reportes.service.ReporteService;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/ventas")
    public List<VentaReporte> obtenerReporteVentas() {
        return reporteService.generarReporteVentas();
    }

    // Método para agregar una nueva venta
    @PostMapping("/ventas")
    public VentaReporte agregarVenta(@RequestBody VentaReporte ventaReporte) {
        return reporteService.agregarVenta(ventaReporte);
    }
}