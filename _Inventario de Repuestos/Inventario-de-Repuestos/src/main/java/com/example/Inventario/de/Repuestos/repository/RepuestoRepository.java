package com.example.Inventario.de.Repuestos.repository;

import com.example.Inventario.de.Repuestos.model.Repuesto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {

    List<Repuesto> findByStockLessThan(Integer stockMinimo);
}
