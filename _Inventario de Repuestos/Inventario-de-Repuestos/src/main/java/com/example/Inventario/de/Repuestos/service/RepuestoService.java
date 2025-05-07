package com.example.Inventario.de.Repuestos.service;

import com.example.Inventario.de.Repuestos.model.Repuesto;
import com.example.Inventario.de.Repuestos.repository.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    public List<Repuesto> listarRepuestos() {
        return repuestoRepository.findAll();
    }

    public Repuesto buscarRepuesto(Long id) {
        return repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
    }

    public Repuesto agregarRepuesto(Repuesto repuesto) {
        repuesto.setFechaActualizacion(new Date());
        return repuestoRepository.save(repuesto);
    }

    public void eliminarRepuesto(Long id) {
        repuestoRepository.deleteById(id);
    }

    public void verificarStock() {
        List<Repuesto> repuestosBajos = repuestoRepository.findByStockLessThan(5);
        repuestosBajos.forEach(rep -> {
            rep.setStock(rep.getStock() + 10);
            repuestoRepository.save(rep);
        });
    }
}
