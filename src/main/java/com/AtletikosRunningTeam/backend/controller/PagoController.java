package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.model.Pago;
import com.AtletikosRunningTeam.backend.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pago> pagoID(@PathVariable int id) {
        return pagoService.encontrarPorID(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPagoID(@PathVariable int id) {
        pagoService.eliminarPorID(id);
        return new ResponseEntity<>("Usuario borrado correctamente", HttpStatus.OK);
    }
}
