package com.example.Reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Reportes.model.VentaReporte;

@Repository
public interface ReporteRepository extends JpaRepository<VentaReporte, Integer> {
}