package com.example.Gestion.de.Repository;

import com.example.Gestion.de.dto.UsuarioDTO;
import com.example.gestiondesucursales.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Long> {}