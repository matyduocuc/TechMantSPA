package com.example.Monitoreo.de.Equipos.service;

import com.example.Monitoreo.de.Equipos.model.Equipo;
import com.example.Monitoreo.de.Equipos.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class EquipoService {
    
    private final EquipoRepository equipoRepository;
    private final Environment environment;
    
    @Autowired
    public EquipoService(EquipoRepository equipoRepository, Environment environment) {
        this.equipoRepository = equipoRepository;
        this.environment = environment;
    }
    
    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }
    
    public Equipo buscarPorId(Long id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }
    
    public Equipo registrarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }
    
    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
    
    @Scheduled(fixedRateString = "${monitoreo.intervalo}")
    public void monitorearEquipos() {
        List<Equipo> equipos = listarTodos();
        equipos.forEach(equipo -> {
            // Simular lectura de sensores IoT
            equipo.setTemperatura(Math.random() * 100);
            equipo.setHumedad(Math.random() * 100);
            equipo.setEstado(equipo.getTemperatura() < 70);
            equipoRepository.save(equipo);
        });
    }
    
    public List<Equipo> obtenerEquiposConProblemas() {
        Double umbral = Double.parseDouble(environment.getProperty("monitoreo.umbral-temperatura"));
        return equipoRepository.findByTemperaturaGreaterThan(umbral);
    }
}