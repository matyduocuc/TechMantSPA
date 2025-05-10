package com.example.Soporte.al.Cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Soporte.al.Cliente.model.Soporte;
import com.example.Soporte.al.Cliente.repository.SoporteRepository;

@Service
public class SoporteService {

    private final SoporteRepository soporteRepository;

    public SoporteService(SoporteRepository soporteRepository) {
        this.soporteRepository = soporteRepository;
    }

    public List<Soporte> obtenerTodos() {
        return soporteRepository.findAll();
    }

    public Soporte crearSoporte(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public Optional<Soporte> obtenerPorId(Long id) {
        return soporteRepository.findById(id);
    }

    public void eliminarSoporte(Long id) {
        soporteRepository.deleteById(id);
    }
}
