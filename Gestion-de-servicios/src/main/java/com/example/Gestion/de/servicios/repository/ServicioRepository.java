package com.example.Gestion.de.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.de.servicios.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
