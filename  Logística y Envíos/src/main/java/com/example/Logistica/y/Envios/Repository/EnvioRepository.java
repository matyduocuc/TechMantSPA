package com.example.Logistica.y.Envios.Repository;

import com.example.Logistica.y.Envios.Model.Envio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    Envio findByCodigoSeguimiento(String codigoSeguimiento);
    List<Envio> findByEstado(String estado);
}
