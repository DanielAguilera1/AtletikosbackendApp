package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.model.Pago;
import com.AtletikosRunningTeam.backend.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> encontrarPorID(Integer id) {
        return pagoRepository.findById(id);
    }

    public void eliminarPorID (Integer id) {
        pagoRepository.findById(id).ifPresent(pagoRepository::delete);
    }
}
