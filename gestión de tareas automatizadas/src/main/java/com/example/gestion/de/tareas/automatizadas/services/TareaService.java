package com.example.gestion.de.tareas.automatizadas.services;

import com.example.gestion.de.tareas.automatizadas.dto.TareaDTO;
import com.example.gestion.de.tareas.automatizadas.model.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> obtenerTodasLasTareas();
    Tarea obtenerTareaPorId(Long id);
    Tarea crearTarea(TareaDTO tareaDTO);
    Tarea actualizarTarea(Long id, TareaDTO tareaDTO);
    void eliminarTarea(Long id);
}
