package com.example.Automatizacion.de.Tareas.Repetitivas.controller;

import com.example.Automatizacion.de.Tareas.Repetitivas.dto.TareaDTO;
import com.example.Automatizacion.de.Tareas.Repetitivas.model.Tarea;
import com.example.Automatizacion.de.Tareas.Repetitivas.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
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
}