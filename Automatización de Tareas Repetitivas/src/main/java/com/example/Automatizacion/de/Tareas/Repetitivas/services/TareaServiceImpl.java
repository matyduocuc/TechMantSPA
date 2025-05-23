package com.example.Automatizacion.de.Tareas.Repetitivas.services;

import com.example.Automatizacion.de.Tareas.Repetitivas.dto.TareaDTO;
import com.example.Automatizacion.de.Tareas.Repetitivas.exception.ResourceNotFoundException;
import com.example.Automatizacion.de.Tareas.Repetitivas.model.Tarea;
import com.example.Automatizacion.de.Tareas.Repetitivas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {
    
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
    }

    @Override
    public Tarea crearTarea(TareaDTO tareaDTO) {
        Tarea tarea = new Tarea();
        tarea.setNombre(tareaDTO.getNombre());
        tarea.setDescripcion(tareaDTO.getDescripcion());
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, TareaDTO tareaDTO) {
        return tareaRepository.findById(id).map(tareaExistente -> {
            tareaExistente.setNombre(tareaDTO.getNombre());
            tareaExistente.setDescripcion(tareaDTO.getDescripcion());
            return tareaRepository.save(tareaExistente);
        }).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
        tareaRepository.deleteById(id);
    }
}