package com.example.Gestion.de.Sucursales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.gestiondesucursales")
@EnableJpaRepositories(basePackages = "com.example.gestiondesucursales.repository")
@EntityScan(basePackages = "com.example.gestiondesucursales.model")
public class GestionDeSucursalesApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionDeSucursalesApplication.class, args);
    }
}