package com.AtletikosRunningTeam.backend.controller;

import com.AtletikosRunningTeam.backend.dto.request.PagoDTO;
import com.AtletikosRunningTeam.backend.dto.response.ListarPagos;
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
    public List<ListarPagos> listarPagos() {
        return pagoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pago> pagoID(@PathVariable long id) {
        return pagoService.encontrarPorID(id);
    }

    @PostMapping()
    public ResponseEntity<String> crearPago(@RequestBody PagoDTO pago) {
        pagoService.crearPago(pago);
        return ResponseEntity.ok("Pago Realizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPagoID(@PathVariable long id) {
        pagoService.eliminarPorID(id);
        return new ResponseEntity<>("Pago borrado correctamente", HttpStatus.OK);
    }
}
