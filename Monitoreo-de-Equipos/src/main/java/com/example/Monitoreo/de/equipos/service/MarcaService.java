package com.example.Monitoreo.de.equipos.service;

import com.example.Monitoreo.de.equipos.model.Marca;
import com.example.Monitoreo.de.equipos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }

    public Marca registrarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Marca no encontrada"));
    }

    public void eliminarMarca(Long id) {
        if (!marcaRepository.existsById(id)) {
            throw new IllegalArgumentException("Marca no encontrada");
        }
        marcaRepository.deleteById(id);
    }
}