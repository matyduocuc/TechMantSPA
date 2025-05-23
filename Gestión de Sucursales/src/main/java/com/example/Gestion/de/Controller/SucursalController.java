package com.example.Gestion.de.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.Gestion.de.dto.SucursalDTO;
import com.example.Gestion.de.Servicie.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<SucursalDTO> getAll() {
        return sucursalService.findAll();
    }

    @PostMapping
    public SucursalDTO create(@RequestBody SucursalDTO sucursalDTO) {
        return sucursalService.save(sucursalDTO);
    }

    @GetMapping("/{id}")
    public SucursalDTO getById(@PathVariable Long id) {
        return sucursalService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sucursalService.delete(id);
    }
}
