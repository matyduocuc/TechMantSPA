package com.example.Soporte.Tecnico.repository;

import com.example.Soporte.Tecnico.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}