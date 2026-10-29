package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.dto.request.ActualizarUsuario;
import com.AtletikosRunningTeam.backend.dto.request.LoginUsuario;
import com.AtletikosRunningTeam.backend.dto.request.UsuarioRequest;
import com.AtletikosRunningTeam.backend.dto.response.ListarUsuarios;
import com.AtletikosRunningTeam.backend.model.Usuario;
import com.AtletikosRunningTeam.backend.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsariosController {
    private final UsuarioService usuarioService;

    public UsariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<ListarUsuarios> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> usuarioID(@PathVariable long id) {
        return usuarioService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable long id) {
        usuarioService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> actualizarUsuario(@RequestBody ActualizarUsuario usuario) {
        try {
            usuarioService.actualizarUsuario(usuario);
            return ResponseEntity.ok("Usuario actualizado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}