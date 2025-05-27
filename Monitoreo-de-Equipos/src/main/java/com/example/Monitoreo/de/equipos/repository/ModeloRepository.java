package com.example.Monitoreo.de.equipos.repository;

import com.example.Monitoreo.de.equipos.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {}