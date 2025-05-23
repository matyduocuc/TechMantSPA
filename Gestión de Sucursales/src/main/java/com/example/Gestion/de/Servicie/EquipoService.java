package com.example.Gestion.de.Servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.Gestion.de.model.Equipo;
import com.example.Gestion.de.dto.EquipoDTO;
import com.example.Gestion.de.Repository.EquipoRepository;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<EquipoDTO> findAll() {
        return equipoRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    public EquipoDTO save(EquipoDTO equipoDTO) {
        Equipo equipo = mapToEntity(equipoDTO);
        return mapToDTO(equipoRepository.save(equipo));
    }

    public EquipoDTO findById(Long id) {
        return equipoRepository.findById(id)
            .map(this::mapToDTO)
            .orElse(null);
    }

    public void delete(Long id) {
        equipoRepository.deleteById(id);
    }

    private EquipoDTO mapToDTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setEquipoId(equipo.getEquipoId());
        dto.setNombre(equipo.getNombre());
        dto.setDescripcion(equipo.getDescripcion());
        return dto;
    }

    private Equipo mapToEntity(EquipoDTO dto) {
        Equipo equipo = new Equipo();
        equipo.setEquipoId(dto.getEquipoId());
        equipo.setNombre(dto.getNombre());
        equipo.setDescripcion(dto.getDescripcion());
        return equipo;
    }
}
