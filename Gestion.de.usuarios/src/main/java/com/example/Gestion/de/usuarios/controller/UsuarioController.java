package com.example.Gestion.de.usuarios.controller;

import com.example.Gestion.de.usuarios.model.Usuario;
import com.example.Gestion.de.usuarios.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.createUsuario(usuario);
        return ResponseEntity.ok(nuevo);
    }
}
