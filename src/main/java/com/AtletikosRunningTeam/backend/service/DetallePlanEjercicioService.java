package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.model.DetallePlanEjercicio;
import com.AtletikosRunningTeam.backend.repository.DetallePlanEjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePlanEjercicioService {
    private final DetallePlanEjercicioRepository detallePlanEjercicioRepository;

    public DetallePlanEjercicioService(DetallePlanEjercicioRepository detallePlanEjercicioRepository) {
        this.detallePlanEjercicioRepository = detallePlanEjercicioRepository;
    }

    public List<DetallePlanEjercicio> listarTodos() {
        return detallePlanEjercicioRepository.findAll();
    }

    public Optional<DetallePlanEjercicio> encontrarPorID(Integer id) {
        return detallePlanEjercicioRepository.findById(id);
    }

    public void eliminarPorID (Integer id) {
        detallePlanEjercicioRepository.findById(id).ifPresent(detallePlanEjercicioRepository::delete);
    }
}
