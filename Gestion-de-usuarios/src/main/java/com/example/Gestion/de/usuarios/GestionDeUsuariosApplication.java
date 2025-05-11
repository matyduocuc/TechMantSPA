package com.example.Gestion.de.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Gestion.de.usuarios"})
@EntityScan(basePackages = {"com.example.Gestion.de.usuarios.model"})
@EnableJpaRepositories(basePackages = {"com.example.Gestion.de.usuarios.repository"})
public class GestionDeUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeUsuariosApplication.class, args);
    }

}
