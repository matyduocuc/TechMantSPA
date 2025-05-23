package com.example.Soporte.Tecnico.controller;

import com.example.Soporte.Tecnico.dto.TicketDTO;
import com.example.Soporte.Tecnico.model.Ticket;
import com.example.Soporte.Tecnico.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> obtenerTodosLosTickets() {
        return ticketService.obtenerTodosLosTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerTicketPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.obtenerTicketPorId(id));
    }

    @PostMapping
    public Ticket crearTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.crearTicket(ticketDTO);
    }

    @PutMapping("/{id}")
    public Ticket actualizarTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        return ticketService.actualizarTicket(id, ticketDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable Long id) {
        ticketService.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }
}