package com.example.Logistica.y.Envios.Controller;

import com.example.Logistica.y.Envios.Model.Envio;
import com.example.Logistica.y.Envios.Model.Ruta;
import com.example.Logistica.y.Envios.Service.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logistica")
public class LogisticaController {

    @Autowired
    private LogisticaService logisticaService;

    @PostMapping("/envios")
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(logisticaService.crearEnvio(envio));
    }

    @PatchMapping("/envios/{id}/estado")
    public ResponseEntity<Envio> actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return ResponseEntity.ok(logisticaService.actualizarEstadoEnvio(id, estado));
    }

    @GetMapping("/envios")
    public ResponseEntity<List<Envio>> listarEnvios(
            @RequestParam(required = false) String estado) {
        if (estado != null) {
            return ResponseEntity.ok(logisticaService.obtenerEnviosPorEstado(estado));
        }
        return ResponseEntity.ok(logisticaService.obtenerTodosEnvios());
    }

    @GetMapping("/envios/{codigo}")
    public ResponseEntity<Envio> obtenerEnvio(
            @PathVariable String codigo) {
        return ResponseEntity.ok(logisticaService.obtenerEnvioPorCodigo(codigo));
    }

    @PostMapping("/envios/{idEnvio}/rutas")
    public ResponseEntity<Ruta> agregarRuta(
            @PathVariable Long idEnvio,
            @RequestBody Ruta ruta) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(logisticaService.agregarRutaAEnvio(idEnvio, ruta));
    }

    @GetMapping("/envios/{idEnvio}/rutas")
    public ResponseEntity<List<Ruta>> listarRutasPorEnvio(
            @PathVariable Long idEnvio) {
        return ResponseEntity.ok(logisticaService.obtenerRutasPorEnvio(idEnvio));
    }


    
}
