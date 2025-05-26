package com.example.Soporte.al.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.Soporte.al.cliente.model.Ticket;
import com.example.Soporte.al.cliente.service.SoporteService;

@RestController
@RequestMapping("/api/soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping("/tickets")
    public List<Ticket> obtenerTodosLosTickets() {
        return soporteService.ObtenerTodosLosTickets();
    }

    @PostMapping("/tickets")
    public Ticket crearTicket(@RequestBody Ticket ticket) {
        return soporteService.crearTicket(ticket);
    }
}