package com.example.Monitoreo.de.equipos.service;

import com.example.Monitoreo.de.equipos.model.Modelo;
import com.example.Monitoreo.de.equipos.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public Modelo registrarModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Modelo no encontrado"));
    }

    public void eliminarModelo(Long id) {
        if (!modeloRepository.existsById(id)) {
            throw new IllegalArgumentException("Modelo no encontrado");
        }
        modeloRepository.deleteById(id);
    }
}