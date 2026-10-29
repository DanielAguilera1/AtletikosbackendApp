package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.dto.request.PagoDTO;
import com.AtletikosRunningTeam.backend.dto.response.ListarPagos;
import com.AtletikosRunningTeam.backend.model.Pago;
import com.AtletikosRunningTeam.backend.model.Usuario;
import com.AtletikosRunningTeam.backend.repository.PagoRepository;
import com.AtletikosRunningTeam.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;
    private final UsuarioRepository usuarioRepository;

    public PagoService(PagoRepository pagoRepository, UsuarioRepository usuarioRepository) {
        this.pagoRepository = pagoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void crearPago(PagoDTO pagoDTO) {
        System.out.println("si llego aqui?");
        Usuario usuarioEncontrado = usuarioRepository.findById(pagoDTO.getUsuario())
                .orElseThrow(() -> new RuntimeException("El usuario con ID " + pagoDTO.getUsuario() + " no existe"));

        System.out.println(usuarioEncontrado);

        Pago pago = new Pago();
        pago.setUsuario(usuarioEncontrado);
        pago.setMonto(pagoDTO.getMonto());
        pago.setFechaPago(LocalDate.now());
        pago.setMetodoPago(pagoDTO.getMetodoPago());
        pago.setEstadoPago(pagoDTO.getEstadoPago());
        pagoRepository.save(pago);
    }

    public List<ListarPagos> listarTodos() {
        return pagoRepository.findAll().stream().map(pago -> new ListarPagos(
                pago.getId(),
                pago.getUsuario().getId(),
                pago.getMonto(),
                pago.getMetodoPago(),
                pago.getEstadoPago(),
                pago.getFechaPago()
        )).toList();
    }

    public Optional<Pago> encontrarPorID(long id) {
        return pagoRepository.findById(id);
    }

    public void eliminarPorID(long id) {
        pagoRepository.findById(id).ifPresent(pagoRepository::delete);
    }
}
