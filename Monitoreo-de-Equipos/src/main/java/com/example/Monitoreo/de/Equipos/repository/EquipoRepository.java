package com.example.Monitoreo.de.Equipos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Monitoreo.de.Equipos.model.Equipo;

@Repository


public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByEstado(Boolean estado);
    List<Equipo> findByTemperaturaGreaterThan(Double temperatura);
    Equipo findBySerial(String serial);
}
