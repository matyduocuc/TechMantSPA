package com.example.Inventario.de.Repuestos.controller;

import com.example.Inventario.de.Repuestos.model.Repuesto;
import com.example.Inventario.de.Repuestos.service.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    @GetMapping
    public ResponseEntity<List<Repuesto>> listarRepuestos() {
        List<Repuesto> repuestos = repuestoService.listarRepuestos();
        return repuestos.isEmpty() 
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(repuestos);
    }

    @PostMapping
    public ResponseEntity<Repuesto> agregarRepuesto(@RequestBody Repuesto repuesto) {
        Repuesto nuevoRepuesto = repuestoService.agregarRepuesto(repuesto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRepuesto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(repuestoService.buscarRepuesto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRepuesto(@PathVariable Long id) {
        repuestoService.eliminarRepuesto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reposicion-stock")
    public ResponseEntity<String> reposicionStock() {
        repuestoService.verificarStock();
        return ResponseEntity.ok("Reposición de stock completada");
    }
}
