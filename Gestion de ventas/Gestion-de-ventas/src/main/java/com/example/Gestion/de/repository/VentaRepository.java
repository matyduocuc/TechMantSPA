package com.example.Gestion.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion.de.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
