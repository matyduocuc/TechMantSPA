package com.example.Gestion.de.usuarios.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class VentaClient {

    private final RestTemplate restTemplate;

    public VentaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeVenta(Long idVenta) {
        try {
            String url = "http://localhost:8082/ventas/" + idVenta;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}