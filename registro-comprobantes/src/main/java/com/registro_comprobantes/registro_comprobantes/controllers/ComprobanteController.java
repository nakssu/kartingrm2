package com.registro_comprobantes.registro_comprobantes.controllers;

import com.registro_comprobantes.registro_comprobantes.entities.ComprobanteEntity;
import com.registro_comprobantes.registro_comprobantes.services.ComprobanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/comprobantes")
@RequiredArgsConstructor
public class ComprobanteController {
    private final ComprobanteService comprobanteService;

    @PostMapping("/emitir")
    public ComprobanteEntity emitirComprobante(@RequestParam Long reservaId, @RequestParam int monto, @RequestParam String correoCliente) {
        return comprobanteService.emitirComprobante(reservaId, monto, correoCliente);
    }

    @GetMapping("/reserva/{reservaId}")
    public Optional<ComprobanteEntity> getComprobanteByReserva(@PathVariable Long reservaId) {
        return comprobanteService.getByReservaId(reservaId);
    }

    @GetMapping("/{id}")
    public ComprobanteEntity getComprobanteById(@PathVariable Long id) {
        return comprobanteService.getById(id);
    }
}