package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.TecnicoDTO;
import com.example.Soporte.Tecnico.exception.ResourceNotFoundException;
import com.example.Soporte.Tecnico.model.Tecnico;
import com.example.Soporte.Tecnico.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {
    
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoRepository.findAll();
    }

    @Override
    public Tecnico obtenerTecnicoPorId(Long id) {
        return tecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico no encontrado con ID: " + id));
    }

    @Override
    public Tecnico crearTecnico(TecnicoDTO tecnicoDTO) {
        Tecnico nuevoTecnico = new Tecnico();
        nuevoTecnico.setNombre(tecnicoDTO.getNombre());
        nuevoTecnico.setEspecialidad(tecnicoDTO.getEspecialidad());
        return tecnicoRepository.save(nuevoTecnico);
    }

    @Override
    public Tecnico actualizarTecnico(Long id, TecnicoDTO tecnicoDTO) {
        Tecnico tecnicoExistente = obtenerTecnicoPorId(id);
        tecnicoExistente.setNombre(tecnicoDTO.getNombre());
        tecnicoExistente.setEspecialidad(tecnicoDTO.getEspecialidad());
        return tecnicoRepository.save(tecnicoExistente);
    }

    @Override
    public void eliminarTecnico(Long id) {
        tecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico no encontrado con ID: " + id));
        tecnicoRepository.deleteById(id);
    }
}