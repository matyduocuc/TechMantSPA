package com.example.Monitoreo.de.equipos.controller;

import com.example.Monitoreo.de.equipos.model.Modelo;
import com.example.Monitoreo.de.equipos.service.ModeloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {
    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> listarModelos() {
        return modeloService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Modelo> registrarModelo(@RequestBody Modelo modelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloService.registrarModelo(modelo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(modeloService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModelo(@PathVariable Long id) {
        modeloService.eliminarModelo(id);
        return ResponseEntity.noContent().build();
    }
}