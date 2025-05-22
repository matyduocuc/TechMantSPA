package com.example.Facturacion.y.Pagos.repository;

import com.example.Facturacion.y.Pagos.model.EstadoFactura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EstadoFacturaRepository extends CrudRepository<EstadoFactura, Long> {
    Optional<EstadoFactura> findByNombre(String nombre);
}