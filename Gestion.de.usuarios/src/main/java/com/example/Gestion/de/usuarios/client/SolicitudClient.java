package com.example.Gestion.de.usuarios.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SolicitudClient {

    private final RestTemplate restTemplate;

    public SolicitudClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeSolicitud(Long idSolicitud) {
        try {
            String url = "http://localhost:8085/solicitudes/" + idSolicitud;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}