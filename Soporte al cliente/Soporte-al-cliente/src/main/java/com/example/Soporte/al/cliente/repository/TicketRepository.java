package com.example.Soporte.al.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Soporte.al.cliente.model.Ticket;

@Repository
public interface TicketRepository extends 
JpaRepository<Ticket, Integer> {

}
