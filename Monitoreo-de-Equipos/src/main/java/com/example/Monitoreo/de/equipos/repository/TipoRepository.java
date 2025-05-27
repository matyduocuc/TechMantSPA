package com.example.Monitoreo.de.equipos.repository;

import com.example.Monitoreo.de.equipos.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {}