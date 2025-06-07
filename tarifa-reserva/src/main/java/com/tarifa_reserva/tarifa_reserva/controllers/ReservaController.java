package com.tarifa_reserva.tarifa_reserva.controllers;

import com.tarifa_reserva.tarifa_reserva.entities.ReservaEntity;
import com.tarifa_reserva.tarifa_reserva.services.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @GetMapping("/")
    public List<ReservaEntity> getReservas() {
        return reservaService.getReservas();
    }

    @PostMapping("/")
    public ReservaEntity crearReserva(@RequestBody ReservaEntity reserva) {
        return reservaService.saveReserva(reserva);
    }
}