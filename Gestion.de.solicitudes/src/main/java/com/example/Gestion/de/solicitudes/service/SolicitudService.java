package com.example.Gestion.de.solicitudes.service;

import com.example.Gestion.de.solicitudes.model.Solicitud;

public interface SolicitudService {
    Solicitud crearSolicitud(Solicitud solicitud);
    Solicitud obtenerSolicitud(Long id);
    void eliminarSolicitud(Long id);
    Solicitud actualizarSolicitud(Long id, Solicitud solicitud);
}