package com.example.Facturacion.y.Pagos.repository;

import com.example.Facturacion.y.Pagos.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
    Optional<MetodoPago> findByNombre(String nombre);
}
