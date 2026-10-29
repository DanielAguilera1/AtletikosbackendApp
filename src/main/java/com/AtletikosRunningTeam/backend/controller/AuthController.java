package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.dto.request.LoginUsuario;
import com.AtletikosRunningTeam.backend.dto.request.UsuarioRequest;
import com.AtletikosRunningTeam.backend.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UsuarioRequest usuario) {
        boolean resultado = usuarioService.registrarUsuario(usuario);
        if (!resultado) {
            return ResponseEntity.badRequest().body("Ya existe un Usuario con ese Email");
        }
        return new ResponseEntity<>("Registro Exitoso!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUsuario usuario) {
        boolean isAuthenticated = usuarioService.login(usuario);

        if (isAuthenticated) {
            return ResponseEntity.ok("¡Login exitoso! Credenciales correctas.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos.");
        }
    }
}
