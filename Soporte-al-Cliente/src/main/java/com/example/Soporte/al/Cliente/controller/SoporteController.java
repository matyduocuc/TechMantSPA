package com.example.Soporte.al.Cliente.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Soporte.al.Cliente.model.Soporte;
import com.example.Soporte.al.Cliente.service.SoporteService;

@RestController
@RequestMapping("/soporte")
public class SoporteController {

    private final SoporteService soporteService;

    public SoporteController(SoporteService soporteService) {
        this.soporteService = soporteService;
    }

    @GetMapping
    public List<Soporte> listarTodos() {
        return soporteService.obtenerTodos();
    }

    @PostMapping
    public Soporte crear(@RequestBody Soporte soporte) {
        return soporteService.crearSoporte(soporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        soporteService.eliminarSoporte(id);
    }
}
