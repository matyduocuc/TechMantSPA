package com.example.Gestion.de.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.ventas.model.Ventas;
import com.example.Gestion.de.ventas.repository.VentasRepository;

@Service
public class VentasService {
    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> listarVentas() {
        return ventasRepository.findAll();
    }

    public Ventas agregarVenta(Ventas venta) {
        return ventasRepository.save(venta);
    }

    public Ventas buscarVenta(Integer id) {
        return ventasRepository.findById(id).orElse(null);
    }

    public void eliminarVenta(Integer id) {
        ventasRepository.deleteById(id);
    }
}