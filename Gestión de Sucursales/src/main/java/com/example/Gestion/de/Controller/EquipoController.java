package com.example.Gestion.de.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.Gestion.de.dto.EquipoDTO;
import com.example.Gestion.de.Servicie.EquipoService;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<EquipoDTO> getAll() {
        return equipoService.findAll();
    }

    @PostMapping
    public EquipoDTO create(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.save(equipoDTO);
    }

    @GetMapping("/{id}")
    public EquipoDTO getById(@PathVariable Long id) {
        return equipoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipoService.delete(id);
    }
}
