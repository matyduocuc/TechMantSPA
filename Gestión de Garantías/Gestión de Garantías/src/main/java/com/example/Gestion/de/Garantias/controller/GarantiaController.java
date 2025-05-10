package com.example.Gestion.de.Garantias.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.de.Garantias.model.Garantia;
import com.example.Gestion.de.Garantias.service.GarantiaService;

@RestController
@RequestMapping("/garantias")

public class GarantiaController {

    @Autowired
    private GarantiaService GarantiaService;

    @GetMapping
    public List<Garantia> listarGarantias() {
        return GarantiaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Garantia> obtenerGarantia(@PathVariable Long id) {
        return GarantiaService.obtenerPorId(id);
    }

    @PostMapping
    public Garantia crearGarantia(@RequestBody Garantia garantia) {
        return GarantiaService.crearGarantia(garantia);
    }

    @DeleteMapping("/{id}")
    public void eliminarGarantia(@PathVariable Long id) {
        GarantiaService.eliminarGarantia(id);
    }
}
