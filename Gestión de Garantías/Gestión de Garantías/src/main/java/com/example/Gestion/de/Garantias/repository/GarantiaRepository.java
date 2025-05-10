package com.example.Gestion.de.Garantias.repository;

import com.example.Gestion.de.Garantias.model.Garantia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarantiaRepository extends JpaRepository<Garantia, Long> {
}
