package com.example.Monitoreo.de.equipos.controller;

import com.example.Monitoreo.de.equipos.model.Tipo;
import com.example.Monitoreo.de.equipos.service.TipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {
    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping
    public List<Tipo> listarTipos() {
        return tipoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Tipo> registrarTipo(@RequestBody Tipo tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoService.registrarTipo(tipo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipo(@PathVariable Long id) {
        tipoService.eliminarTipo(id);
        return ResponseEntity.noContent().build();
    }
}