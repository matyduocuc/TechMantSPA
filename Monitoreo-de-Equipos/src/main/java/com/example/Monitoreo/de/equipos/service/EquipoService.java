package com.example.Monitoreo.de.equipos.service;

import com.example.Monitoreo.de.equipos.model.Equipo;
import com.example.Monitoreo.de.equipos.repository.EquipoRepository;
import com.example.Monitoreo.de.equipos.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;
    private final MarcaRepository marcaRepository;

    public EquipoService(EquipoRepository equipoRepository, MarcaRepository marcaRepository) {
        this.equipoRepository = equipoRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }

    public Equipo registrarEquipo(Equipo equipo) {
        if (!marcaRepository.existsById(equipo.getIdMarca())) {
            throw new IllegalArgumentException("La marca no existe");
        }
        return equipoRepository.save(equipo);
    }

    public Equipo buscarPorId(Long id) {
        return equipoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado"));
    }

    public void eliminarEquipo(Long id) {
        if (!equipoRepository.existsById(id)) {
            throw new IllegalArgumentException("Equipo no encontrado");
        }
        equipoRepository.deleteById(id);
    }
}