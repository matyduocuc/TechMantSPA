package com.example.Gestion.de.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Gestion.de.ventas.model.Ventas;
import com.example.Gestion.de.ventas.service.VentasService;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public ResponseEntity<List<Ventas>> listarVentas() {
        List<Ventas> ventas = ventasService.listarVentas();
        return ventas.isEmpty() 
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<Ventas> agregarVenta(@RequestBody Ventas venta) {
        Ventas nuevaVenta = ventasService.agregarVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> buscarPorId(@PathVariable Integer id) {
        Ventas venta = ventasService.buscarVenta(id);
        return venta != null 
            ? ResponseEntity.ok(venta) 
            : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        if (ventasService.buscarVenta(id) != null) {
            ventasService.eliminarVenta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}