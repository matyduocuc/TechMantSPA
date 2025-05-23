package com.example.Soporte.Tecnico.services;

import com.example.Soporte.Tecnico.dto.TecnicoDTO;
import com.example.Soporte.Tecnico.model.Tecnico;

import java.util.List;

public interface TecnicoService {
    List<Tecnico> obtenerTodosLosTecnicos();
    Tecnico obtenerTecnicoPorId(Long id);
    Tecnico crearTecnico(TecnicoDTO tecnicoDTO);
    Tecnico actualizarTecnico(Long id, TecnicoDTO tecnicoDTO);
    void eliminarTecnico(Long id);
}