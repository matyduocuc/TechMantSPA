package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.AsignacionDTO;
import com.example.Soporte.Tecnico.model.Asignacion;
import com.example.Soporte.Tecnico.repository.AsignacionRepository;
import com.example.Soporte.Tecnico.repository.TecnicoRepository;
import com.example.Soporte.Tecnico.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionServiceImpl implements AsignacionService {
    
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Asignacion> obtenerTodasLasAsignaciones() {
        return asignacionRepository.findAll();
    }

    @Override
    public Asignacion crearAsignacion(AsignacionDTO asignacionDTO) {
        Asignacion nuevaAsignacion = new Asignacion();
        nuevaAsignacion.setTecnico(tecnicoRepository.findById(asignacionDTO.getTecnicoId()).orElseThrow());
        nuevaAsignacion.setTicket(ticketRepository.findById(asignacionDTO.getTicketId()).orElseThrow());
        return asignacionRepository.save(nuevaAsignacion);
    }
}