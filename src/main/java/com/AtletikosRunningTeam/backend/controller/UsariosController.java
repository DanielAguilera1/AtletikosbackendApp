package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.dto.request.CrearUsuarioRequest;
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
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    @PostMapping()
    public ResponseEntity<String> crearUsuario(@RequestBody CrearUsuarioRequest usuario) {
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> usuarioID(@PathVariable int id) {
        return usuarioService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        usuarioService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }
}