package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.model.PlanEntrenamiento;
import com.AtletikosRunningTeam.backend.service.PlanEntrenamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planesentrenamiento")
public class PlanEntrenamientoController {
    private final PlanEntrenamientoService planEntrenamientoService;

    public PlanEntrenamientoController(PlanEntrenamientoService planEntrenamientoService) {
        this.planEntrenamientoService = planEntrenamientoService;
    }

    @GetMapping
    public List<PlanEntrenamiento> listarPlanesEntrenamiento() {
        return planEntrenamientoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PlanEntrenamiento> planEntrenamientoID(@PathVariable int id) {
        return planEntrenamientoService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPlanEntrenamiento(@PathVariable int id) {
        planEntrenamientoService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }
}
