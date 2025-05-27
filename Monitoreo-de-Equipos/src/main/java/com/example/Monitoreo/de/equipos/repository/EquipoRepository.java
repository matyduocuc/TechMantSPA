package com.example.Monitoreo.de.equipos.repository;

import com.example.Monitoreo.de.equipos.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {}