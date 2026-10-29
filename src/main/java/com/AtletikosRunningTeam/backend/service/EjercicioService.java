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

    public void crearEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.save(ejercicio);
    }

    public void ActualizarEjercicio(Ejercicio ejercicio){
        ejercicioRepository.findById(ejercicio.getId())
                .orElseThrow(() -> new RuntimeException("ID: " + ejercicio.getId() + " del ejercicio no encontrado"));

        ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> listarTodos() {
        return ejercicioRepository.findAll();
    }

    public Optional<Ejercicio> encontrarPorID(Integer id) {
        return ejercicioRepository.findById(id);
    }

    public void eliminarPorID(Integer id) {
        ejercicioRepository.findById(id).ifPresent(ejercicioRepository::delete);
    }
}
