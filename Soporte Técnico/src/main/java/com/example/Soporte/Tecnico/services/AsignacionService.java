package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.AsignacionDTO;
import com.example.Soporte.Tecnico.model.Asignacion;

import java.util.List;

public interface AsignacionService {
    List<Asignacion> obtenerTodasLasAsignaciones();
    Asignacion crearAsignacion(AsignacionDTO asignacionDTO);
}