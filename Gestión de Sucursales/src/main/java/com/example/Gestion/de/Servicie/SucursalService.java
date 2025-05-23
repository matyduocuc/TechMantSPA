package com.example.Gestion.de.Servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.Gestion.de.model.Sucursal;
import com.example.Gestion.de.dto.SucursalDTO;
import com.example.Gestion.de.exception.ResourceNotFoundException;
import com.example.Gestion.de.Repository.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<SucursalDTO> findAll() {
        return sucursalRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    public SucursalDTO save(SucursalDTO sucursalDTO) {
        Sucursal sucursal = mapToEntity(sucursalDTO);
        return mapToDTO(sucursalRepository.save(sucursal));
    }

    public SucursalDTO findById(Long id) {
        return sucursalRepository.findById(id)
            .map(this::mapToDTO)
            .orElseThrow(() -> new ResourceNotFoundException("Sucursal no encontrada con ID: " + id));
    }

    public void delete(Long id) {
        sucursalRepository.deleteById(id);
    }

    private SucursalDTO mapToDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setSucursalId(sucursal.getSucursalId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());
        dto.setTelefono(sucursal.getTelefono());
        dto.setResponsableId(sucursal.getResponsable().getUsuarioId());
        dto.setActiva(sucursal.getActiva());
        return dto;
    }

    private Sucursal mapToEntity(SucursalDTO dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setSucursalId(dto.getSucursalId());
        sucursal.setNombre(dto.getNombre());
        sucursal.setDireccion(dto.getDireccion());
        sucursal.setTelefono(dto.getTelefono());
        // Establecer responsable según responsableId si es necesario
        return sucursal;
    }
}