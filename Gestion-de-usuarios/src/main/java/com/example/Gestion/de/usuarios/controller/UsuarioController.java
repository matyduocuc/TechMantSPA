package com.example.Gestion.de.usuarios.controller;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import com.example.Gestion.de.usuarios.model.Rol;
import com.example.Gestion.de.usuarios.model.Usuario;
import com.example.Gestion.de.usuarios.services.RolService;
import com.example.Gestion.de.usuarios.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Rol>> getRoles() {
        List<Rol> roles = rolService.obtenerTodos();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol ADMIN pueden listar usuarios
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER') and #id == authentication.principal.id")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @PostMapping
    @RolesAllowed("ADMIN")  // Solo los usuarios con el rol ADMIN pueden crear usuarios
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequest request) {
        Usuario nuevo = usuarioService.crearUsuario(
                request.getNombre(),
                request.getApellido(),
                request.getCorreo(),
                request.getClave(),
                request.getEstado(),
                request.getTelefono(),
                request.getIdDireccion(),
                request.getRolId()
        );
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        Usuario actualizado = usuarioService.actualizarUsuario(
                id,
                request.getNombre(),
                request.getApellido(),
                request.getCorreo(),
                request.getClave(),
                request.getEstado(),
                request.getTelefono(),
                request.getIdDireccion(),
                request.getRolId()
        );
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Solo los usuarios con el rol ADMIN pueden eliminar usuarios
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // DTO para entrada de datos
    public static class UsuarioRequest {
        private String nombre;
        private String apellido;
        private String correo;
        private String clave;
        private Boolean estado;
        private String telefono;
        private Long idDireccion;
        private Long rolId;

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }

        public String getCorreo() { return correo; }
        public void setCorreo(String correo) { this.correo = correo; }

        public String getClave() { return clave; }
        public void setClave(String clave) { this.clave = clave; }

        public Boolean getEstado() { return estado; }
        public void setEstado(Boolean estado) { this.estado = estado; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public Long getIdDireccion() { return idDireccion; }
        public void setIdDireccion(Long idDireccion) { this.idDireccion = idDireccion; }

        public Long getRolId() { return rolId; }
        public void setRolId(Long rolId) { this.rolId = rolId; }
    }
}
