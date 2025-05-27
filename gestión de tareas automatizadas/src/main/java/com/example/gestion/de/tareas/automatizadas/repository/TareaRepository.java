package com.example.gestion.de.tareas.automatizadas.repository;

import com.example.gestion.de.tareas.automatizadas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}