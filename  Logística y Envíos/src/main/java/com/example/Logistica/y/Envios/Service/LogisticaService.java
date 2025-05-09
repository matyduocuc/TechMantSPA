package com.example.Logistica.y.Envios.Service;

import com.example.Logistica.y.Envios.Model.Envio;
import com.example.Logistica.y.Envios.Model.Ruta;
import com.example.Logistica.y.Envios.Repository.EnvioRepository;
import com.example.Logistica.y.Envios.Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogisticaService {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private RutaRepository rutaRepository;

    public Envio crearEnvio(Envio envio) {
        envio.setFechaCreacion(LocalDateTime.now());
        envio.setEstado("PREPARACION");
        return envioRepository.save(envio);
    }

    public Envio actualizarEstadoEnvio(Long idEnvio, String nuevoEstado) {
        Envio envio = envioRepository.findById(idEnvio)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));
        envio.setEstado(nuevoEstado);
        if ("ENTREGADO".equals(nuevoEstado)) {
            envio.setFechaEntrega(LocalDateTime.now());
        }
        return envioRepository.save(envio);
    }

    public List<Envio> obtenerEnviosPorEstado(String estado) {
        return envioRepository.findByEstado(estado);
    }

    public List<Envio> obtenerTodosEnvios() {
        return envioRepository.findAll();
    }

    public Envio obtenerEnvioPorCodigo(String codigoSeguimiento) {
        return envioRepository.findByCodigoSeguimiento(codigoSeguimiento);
    }

    public Ruta agregarRutaAEnvio(Long idEnvio, Ruta ruta) {
        Envio envio = envioRepository.findById(idEnvio)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));
        ruta.setEnvio(envio);
        return rutaRepository.save(ruta);
    }

    public List<Ruta> obtenerRutasPorEnvio(Long idEnvio) {
        return rutaRepository.findByEnvioIdEnvio(idEnvio);
    }
}
