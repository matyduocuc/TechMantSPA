package com.example.Soporte.Tecnico.controller;

import com.example.Soporte.Tecnico.dto.AsignacionDTO;
import com.example.Soporte.Tecnico.model.Asignacion;
import com.example.Soporte.Tecnico.services.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    public List<Asignacion> obtenerTodasLasAsignaciones() {
        return asignacionService.obtenerTodasLasAsignaciones();
    }

    @PostMapping
    public Asignacion crearAsignacion(@RequestBody AsignacionDTO asignacionDTO) {
        return asignacionService.crearAsignacion(asignacionDTO);
    }
}