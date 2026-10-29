package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.model.Ejercicio;
import com.AtletikosRunningTeam.backend.service.EjercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {
    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @GetMapping()
    public List<Ejercicio> listarEjercicios() {
        return ejercicioService.listarTodos();
    }

    @PostMapping()
    public ResponseEntity<String> CrearEjercicio (Ejercicio ejercicio) {
        ejercicioService.crearEjercicio(ejercicio);
        return ResponseEntity.ok("Ejercicio creado Correctamente");
    }

    @PutMapping()
    public ResponseEntity<String> ActualizarEjercicio (Ejercicio ejercicio) {
        try {
            ejercicioService.ActualizarEjercicio(ejercicio);
            return ResponseEntity.ok("Ejercicio Actualizado Correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<Ejercicio> ejercicioID(@PathVariable int id) {
        return ejercicioService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarEjercicioID(@PathVariable int id) {
        ejercicioService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }
}
