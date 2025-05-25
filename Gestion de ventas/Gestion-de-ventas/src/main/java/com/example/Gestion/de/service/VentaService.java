package com.example.Gestion.de.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.model.Venta;
import com.example.Gestion.de.repository.VentaRepository;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta buscarVenta(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public void eliminarVenta(Integer id) {
        ventaRepository.deleteById(id);
    }

}
