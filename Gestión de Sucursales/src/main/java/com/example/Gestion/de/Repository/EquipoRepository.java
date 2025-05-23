package com.example.Gestion.de.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.de.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
