package com.example.Soporte.Tecnico.controller;

import com.example.Soporte.Tecnico.dto.TecnicoDTO;
import com.example.Soporte.Tecnico.model.Tecnico;
import com.example.Soporte.Tecnico.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoService.obtenerTodosLosTecnicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> obtenerTecnicoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tecnicoService.obtenerTecnicoPorId(id));
    }

    @PostMapping
    public Tecnico crearTecnico(@RequestBody TecnicoDTO tecnicoDTO) {
        return tecnicoService.crearTecnico(tecnicoDTO);
    }

    @PutMapping("/{id}")
    public Tecnico actualizarTecnico(@PathVariable Long id, @RequestBody TecnicoDTO tecnicoDTO) {
        return tecnicoService.actualizarTecnico(id, tecnicoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTecnico(@PathVariable Long id) {
        tecnicoService.eliminarTecnico(id);
        return ResponseEntity.noContent().build();
    }
}