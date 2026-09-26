package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.model.PlanEntrenamiento;
import com.AtletikosRunningTeam.backend.repository.PlanEntrenamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanEntrenamientoService {
    private final PlanEntrenamientoRepository planEntrenamientoRepository;

    public PlanEntrenamientoService(PlanEntrenamientoRepository planEntrenamientoRepository) {
        this.planEntrenamientoRepository = planEntrenamientoRepository;
    }

    public List<PlanEntrenamiento> listarTodos() {
        return planEntrenamientoRepository.findAll();
    }

    public Optional<PlanEntrenamiento> encontrarPorID(Integer id) {
        return planEntrenamientoRepository.findById(id);
    }

    public void eliminarPorID (Integer id) {
        planEntrenamientoRepository.findById(id).ifPresent(planEntrenamientoRepository::delete);
    }
}
