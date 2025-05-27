package com.example.gestion.de.tareas.automatizadas.services;

import com.example.gestion.de.tareas.automatizadas.dto.TareaDTO;
import com.example.gestion.de.tareas.automatizadas.exception.ResourceNotFoundException;
import com.example.gestion.de.tareas.automatizadas.model.Tarea;
import com.example.gestion.de.tareas.automatizadas.repository.TareaRepository;
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
        tarea.setIdTecnico(tareaDTO.getIdTecnico());
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, TareaDTO tareaDTO) {
        return tareaRepository.findById(id).map(tareaExistente -> {
            tareaExistente.setNombre(tareaDTO.getNombre());
            tareaExistente.setDescripcion(tareaDTO.getDescripcion());
            tareaExistente.setIdTecnico(tareaDTO.getIdTecnico());
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
