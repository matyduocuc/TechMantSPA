package com.example.Gestion.de.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Gestion.de.ventas.model.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}