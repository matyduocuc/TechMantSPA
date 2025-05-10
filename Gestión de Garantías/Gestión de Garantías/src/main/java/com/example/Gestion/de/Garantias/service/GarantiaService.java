package com.example.Gestion.de.Garantias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.Garantias.model.Garantia;
import com.example.Gestion.de.Garantias.repository.GarantiaRepository;

@Service
public class GarantiaService {

    @Autowired
    private GarantiaRepository GarantiaRepository;

    public List<Garantia> listarTodas() {
        return GarantiaRepository.findAll();
    }

    public Optional<Garantia> obtenerPorId(Long id) {
        return GarantiaRepository.findById(id);
    }

    public Garantia crearGarantia(Garantia garantia) {
        return GarantiaRepository.save(garantia);
    }

    public void eliminarGarantia(Long id) {
        GarantiaRepository.deleteById(id);
    }
}
