package com.example.Gestion.de.solicitudes.repository;

import com.example.Gestion.de.solicitudes.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}