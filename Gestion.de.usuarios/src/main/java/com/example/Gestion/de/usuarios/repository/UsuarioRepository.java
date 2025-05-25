package com.example.Gestion.de.usuarios.repository;

import com.example.Gestion.de.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

