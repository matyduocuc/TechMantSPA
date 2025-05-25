package com.example.Gestion.de.servicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.de.servicios.model.Servicio;
import com.example.Gestion.de.servicios.repository.ServicioRepository;

@Service
public class ServicioService {
    @Autowired
        private ServicioRepository servicioRepository;

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public void deleteById(Integer id) {
        servicioRepository.deleteById(id);
    }

}
