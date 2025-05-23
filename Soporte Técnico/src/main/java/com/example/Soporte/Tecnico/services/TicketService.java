package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.TicketDTO;
import com.example.Soporte.Tecnico.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> obtenerTodosLosTickets();
    Ticket obtenerTicketPorId(Long id);
    Ticket crearTicket(TicketDTO ticketDTO);
    Ticket actualizarTicket(Long id, TicketDTO ticketDTO);
    void eliminarTicket(Long id);
}