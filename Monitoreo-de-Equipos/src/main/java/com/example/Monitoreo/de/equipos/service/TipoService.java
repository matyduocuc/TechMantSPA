package com.example.Monitoreo.de.equipos.service;

import com.example.Monitoreo.de.equipos.model.Tipo;
import com.example.Monitoreo.de.equipos.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {
    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }

    public Tipo registrarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public Tipo buscarPorId(Long id) {
        return tipoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Tipo no encontrado"));
    }

    public void eliminarTipo(Long id) {
        if (!tipoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tipo no encontrado");
        }
        tipoRepository.deleteById(id);
    }
}