package com.example.Gestion.de.usuarios.services;

import com.example.Gestion.de.usuarios.model.Rol;
import com.example.Gestion.de.usuarios.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }
}