package com.example.Soporte.al.Cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Soporte.al.Cliente.model.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Long> {
}
