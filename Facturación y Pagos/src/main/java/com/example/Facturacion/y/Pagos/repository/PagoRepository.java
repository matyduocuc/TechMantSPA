package com.example.Facturacion.y.Pagos.repository;

import com.example.Facturacion.y.Pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByFacturaId(Long facturaId);
    
    @Query("SELECT SUM(p.monto) FROM Pago p WHERE p.factura.id = :facturaId")
    Optional<Double> sumMontoByFacturaId(Long facturaId); // Asegúrate de que sea Optional
    
    List<Pago> findByFacturaIsNull();
}