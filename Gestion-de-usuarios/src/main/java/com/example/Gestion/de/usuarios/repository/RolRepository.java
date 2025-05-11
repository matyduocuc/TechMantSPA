package com.example.Gestion.de.usuarios.repository;

import com.example.Gestion.de.usuarios.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
