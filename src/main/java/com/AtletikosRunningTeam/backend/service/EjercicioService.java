package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.model.Ejercicio;
import com.AtletikosRunningTeam.backend.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<Ejercicio> listarTodos() {
        return ejercicioRepository.findAll();
    }

    public Optional<Ejercicio> encontrarPorID(Integer id) {
        return ejercicioRepository.findById(id);
    }

    public void eliminarPorID (Integer id) {
        ejercicioRepository.findById(id).ifPresent(ejercicioRepository::delete);
    }
}
