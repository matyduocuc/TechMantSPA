package com.example.Soporte.Tecnico.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class EquipoClient {

    private final RestTemplate restTemplate;

    public EquipoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeEquipo(Long idEquipo) {
        try {
            String url = "http://localhost:8084/equipo/" + idEquipo;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}