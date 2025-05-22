package com.example.Facturacion.y.Pagos.repository;

import com.example.Facturacion.y.Pagos.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Optional<Factura> findByNumero(String numero);

    List<Factura> findByPagosIsEmpty(); // Ahora funcionará correctamente
}