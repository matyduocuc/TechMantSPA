package com.example.Facturacion.y.Pagos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Facturacion.y.Pagos.WebClient.UsuarioClient;
import com.example.Facturacion.y.Pagos.model.Usuario;

@Service
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    @Autowired
    public UsuarioService(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public Usuario obtenerUsuario(String username) {
        return usuarioClient.obtenerUsuario(username);
    }

    // Puedes agregar más métodos para gestionar usuarios según sea necesario
}
