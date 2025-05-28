package com.example.Gestion.de.ventas.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SoporteClienteClient {

    private final RestTemplate restTemplate;

    public SoporteClienteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeTicket(Long idTicket) {
        try {
            String url = "http://localhost:8088/soporte/" + idTicket;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}