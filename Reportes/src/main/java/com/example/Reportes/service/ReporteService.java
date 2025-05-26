package com.example.Reportes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.Reportes.model.VentaReporte;
import com.example.Reportes.repository.ReporteRepository;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<VentaReporte> generarReporteVentas() {
        return reporteRepository.findAll(); // Lógica para obtener todas las ventas
    }

    public VentaReporte agregarVenta(VentaReporte ventaReporte) {
        return reporteRepository.save(ventaReporte); // Lógica para guardar la nueva venta
    }
}