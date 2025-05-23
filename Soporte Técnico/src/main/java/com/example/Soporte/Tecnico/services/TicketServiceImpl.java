package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.TicketDTO;
import com.example.Soporte.Tecnico.exception.ResourceNotFoundException;
import com.example.Soporte.Tecnico.model.Ticket;
import com.example.Soporte.Tecnico.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> obtenerTodosLosTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket obtenerTicketPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado con ID: " + id));
    }

    @Override
    public Ticket crearTicket(TicketDTO ticketDTO) {
        Ticket nuevoTicket = new Ticket();
        nuevoTicket.setAsunto(ticketDTO.getAsunto());
        nuevoTicket.setDescripcion(ticketDTO.getDescripcion());
        return ticketRepository.save(nuevoTicket);
    }

    @Override
    public Ticket actualizarTicket(Long id, TicketDTO ticketDTO) {
        Ticket ticketExistente = obtenerTicketPorId(id);
        ticketExistente.setAsunto(ticketDTO.getAsunto());
        ticketExistente.setDescripcion(ticketDTO.getDescripcion());
        return ticketRepository.save(ticketExistente);
    }

    @Override
    public void eliminarTicket(Long id) {
        ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado con ID: " + id));
        ticketRepository.deleteById(id);
    }
}