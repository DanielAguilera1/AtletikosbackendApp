package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.model.DetallePlanEjercicio;
import com.AtletikosRunningTeam.backend.service.DetallePlanEjercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DetallePlanEjercicios")
public class DetallePlanEjercicioController {
    private final DetallePlanEjercicioService detallePlanEjercicioService;

    public DetallePlanEjercicioController(DetallePlanEjercicioService detallePlanEjercicioService) {
        this.detallePlanEjercicioService = detallePlanEjercicioService;
    }

    @GetMapping
    public List<DetallePlanEjercicio> listarDetallePlanEjercicios() {
        return detallePlanEjercicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<DetallePlanEjercicio> detallePlanEjercicioID(@PathVariable int id) {
        return detallePlanEjercicioService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarDetallePlanEjercicioID(@PathVariable int id) {
        detallePlanEjercicioService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }
}
