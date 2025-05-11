package com.example.Gestion.de.usuarios.config;

import com.example.Gestion.de.usuarios.model.Rol;
import com.example.Gestion.de.usuarios.model.Usuario;
import com.example.Gestion.de.usuarios.repository.RolRepository;
import com.example.Gestion.de.usuarios.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadDatabase {

   @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

    @Bean
    CommandLineRunner initDatabase(RolRepository rolRepo, UsuarioRepository usuarioRepo, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (rolRepo.count() == 0 && usuarioRepo.count() == 0) {

                // Crear roles
                Rol adminSistema = rolRepo.save(new Rol(null, "Administrador del Sistema", null));
                Rol tecnico = rolRepo.save(new Rol(null, "Técnico", null));
                Rol supervisor = rolRepo.save(new Rol(null, "Supervisor", null));
                Rol cliente = rolRepo.save(new Rol(null, "Cliente", null));
                Rol gestorReportes = rolRepo.save(new Rol(null, "Gestor de Reportes", null));

                // Usuario Admin
                Usuario admin = new Usuario();
                admin.setNombre("ignacio");
                admin.setApellido("londono");
                admin.setCorreo("admin@techmant.com");
                admin.setClave(passwordEncoder.encode("1234")); // Encriptar la contraseña
                admin.setEstado(true);
                admin.setRol(adminSistema);
                usuarioRepo.save(admin);

                // Usuario Técnico
                Usuario tecnico1 = new Usuario();
                 tecnico1.setNombre("tecnico1");
                tecnico1.setApellido("tecnico1");
                tecnico1.setCorreo("tecnico1@techmant.com");
                tecnico1.setClave(passwordEncoder.encode("tecnico123")); // Encriptar la contraseña
                tecnico1.setEstado(true);
                tecnico1.setRol(tecnico);
                usuarioRepo.save(tecnico1);

                // Usuario Supervisor
                Usuario supervisor1 = new Usuario();
                 supervisor1.setNombre("supervisor1");
                supervisor1.setApellido("supervisor1");
                supervisor1.setCorreo("supervisor1@techmant.com");
                supervisor1.setClave(passwordEncoder.encode("supervisor123")); // Encriptar la contraseña
                supervisor1.setEstado(true);
                supervisor1.setRol(supervisor);
                usuarioRepo.save(supervisor1);

                // Usuario Cliente
                Usuario cliente1 = new Usuario();
                 cliente1.setNombre("cliente1");
                cliente1.setApellido("cliente1");
                cliente1.setCorreo("cliente1@techmant.com");
                cliente1.setClave(passwordEncoder.encode("cliente123")); // Encriptar la contraseña
                cliente1.setEstado(true);
                cliente1.setRol(cliente);
                usuarioRepo.save(cliente1);

                 // Usuario Gestor de Reportes
                Usuario gestorReportes1 = new Usuario();
                 gestorReportes1.setNombre("gestorreportes1");
                gestorReportes1.setApellido("gestorreportes1");
                gestorReportes1.setCorreo("gestorreportes1@techmant.com");
                gestorReportes1.setClave(passwordEncoder.encode("gestorreportes123")); // Encriptar la contraseña
                gestorReportes1.setEstado(true);
                gestorReportes1.setRol(gestorReportes);
                usuarioRepo.save(gestorReportes1);

                System.out.println("✅ Roles y usuarios iniciales de TechMant SPA cargados.");
            } else {
                System.out.println("⚠️ Los datos ya existen. No se cargaron nuevos registros.");
            }
        };
    }
}