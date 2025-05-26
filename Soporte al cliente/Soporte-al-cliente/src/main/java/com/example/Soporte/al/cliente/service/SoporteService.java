package com.example.Soporte.al.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Soporte.al.cliente.model.Ticket;
import com.example.Soporte.al.cliente.repository.TicketRepository;

@Service
public class SoporteService {

    @Autowired
    private TicketRepository TicketRepository;

    public List<Ticket> ObtenerTodosLosTickets(){
        return TicketRepository.findAll();

    }
    public Ticket crearTicket(Ticket ticket) {
        return TicketRepository.save(ticket);
    }


    }
    
