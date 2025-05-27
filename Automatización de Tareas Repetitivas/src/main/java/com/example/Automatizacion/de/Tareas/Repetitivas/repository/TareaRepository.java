package com.example.Automatizacion.de.Tareas.Repetitivas.repository;

import com.example.Automatizacion.de.Tareas.Repetitivas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Puedes agregar métodos personalizados si es necesario
}