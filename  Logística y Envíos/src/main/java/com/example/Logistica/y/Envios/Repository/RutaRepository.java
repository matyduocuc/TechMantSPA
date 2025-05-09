package com.example.Logistica.y.Envios.Repository;

import com.example.Logistica.y.Envios.Model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    List<Ruta> findByEnvioIdEnvio(Long idEnvio);
}
