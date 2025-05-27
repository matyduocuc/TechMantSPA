package com.example.Automatizacion.de.Tareas.Repetitivas.controller;

import com.example.Automatizacion.de.Tareas.Repetitivas.dto.TareaDTO;
import com.example.Automatizacion.de.Tareas.Repetitivas.model.Tarea;
import com.example.Automatizacion.de.Tareas.Repetitivas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> obtenerTareas() {
        return tareaService.obtenerTodasLasTareas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaDTO tareaDTO) {
        Tarea nuevaTarea = tareaService.crearTarea(tareaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO) {
        Tarea tareaActualizada = tareaService.actualizarTarea(id, tareaDTO);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}