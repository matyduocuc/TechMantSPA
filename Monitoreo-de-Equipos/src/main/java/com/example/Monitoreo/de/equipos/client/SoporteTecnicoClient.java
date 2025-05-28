package com.example.Monitoreo.de.equipos.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SoporteTecnicoClient {

    private final RestTemplate restTemplate;

    public SoporteTecnicoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existeSoporte(Long idSoporte) {
        try {
            String url = "http://localhost:8083/soporte/" + idSoporte;
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }
}