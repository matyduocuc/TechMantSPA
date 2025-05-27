package com.example.Gestion.de.solicitudes.service;

import com.example.Gestion.de.solicitudes.model.Solicitud;
import com.example.Gestion.de.solicitudes.repository.SolicitudRepository;
import com.example.Gestion.de.solicitudes.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud obtenerSolicitud(Long id) {
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud no encontrada con ID: " + id));
    }

    @Override
    public void eliminarSolicitud(Long id) {
        Solicitud solicitud = obtenerSolicitud(id);
        solicitudRepository.delete(solicitud);
    }

    @Override
    public Solicitud actualizarSolicitud(Long id, Solicitud solicitud) {
        Solicitud solicitudExistente = obtenerSolicitud(id);
        solicitudExistente.setDescripcion(solicitud.getDescripcion());
        solicitudExistente.setUsuarioId(solicitud.getUsuarioId());
        solicitudExistente.setServicioId(solicitud.getServicioId());
        solicitudExistente.setTecnicoId(solicitud.getTecnicoId());
        solicitudExistente.setRepuestoId(solicitud.getRepuestoId());
        solicitudExistente.setEquipoId(solicitud.getEquipoId());
        solicitudExistente.setComentario(solicitud.getComentario());
        return solicitudRepository.save(solicitudExistente);
    }
}