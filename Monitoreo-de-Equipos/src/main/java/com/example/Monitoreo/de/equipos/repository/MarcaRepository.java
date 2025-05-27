package com.example.Monitoreo.de.equipos.repository;

import com.example.Monitoreo.de.equipos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {}