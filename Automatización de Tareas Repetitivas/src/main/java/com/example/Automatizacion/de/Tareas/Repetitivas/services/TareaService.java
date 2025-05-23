package com.example.Automatizacion.de.Tareas.Repetitivas.services;

import com.example.Automatizacion.de.Tareas.Repetitivas.dto.TareaDTO;
import com.example.Automatizacion.de.Tareas.Repetitivas.model.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> obtenerTodasLasTareas();
    Tarea obtenerTareaPorId(Long id);
    Tarea crearTarea(TareaDTO tareaDTO);
    Tarea actualizarTarea(Long id, TareaDTO tareaDTO);
    void eliminarTarea(Long id);
}