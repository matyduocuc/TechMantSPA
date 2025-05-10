package com.example.Monitoreo.de.Equipos.controller;

import com.example.Monitoreo.de.Equipos.model.Equipo;
import com.example.Monitoreo.de.Equipos.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")

public class EquipoController {
    
    private final EquipoService equipoService;
    
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos() {
        List<Equipo> equipos = equipoService.listarTodos();
        return equipos.isEmpty() 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(equipos);
    }
    
    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(@RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.registrarEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.buscarPorId(id));
    }
    
    @GetMapping("/problemas")
    public ResponseEntity<List<Equipo>> equiposConProblemas() {
        List<Equipo> equipos = equipoService.obtenerEquiposConProblemas();
        return ResponseEntity.ok(equipos);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
}
