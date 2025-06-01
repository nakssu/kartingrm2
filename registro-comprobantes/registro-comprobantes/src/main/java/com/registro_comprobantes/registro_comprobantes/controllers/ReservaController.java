package com.registro_comprobantes.registro_comprobantes.controllers;

import com.registro_comprobantes.registro_comprobantes.entities.ReservaEntity;
import com.registro_comprobantes.registro_comprobantes.services.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ReservaEntity registrarReserva(@RequestBody ReservaEntity reserva) {
        return reservaService.registrarReserva(reserva);
    }

    @GetMapping
    public List<ReservaEntity> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ReservaEntity getReserva(@PathVariable Long id) {
        return reservaService.getReserva(id);
    }
}