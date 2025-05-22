package com.example.Facturacion.y.Pagos.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Facturacion.y.Pagos.model.Usuario;

@Service
public class UsuarioClient {

    private final RestTemplate restTemplate;

    @Value("${usuarios.service.url}") // Inyección de la URL del microservicio
    private String usuariosServiceUrl;

    @Autowired
    public UsuarioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Usuario obtenerUsuario(String username) {
        String url = usuariosServiceUrl + "/" + username; // Construir la URL completa
        return restTemplate.getForObject(url, Usuario.class);
    }
}
