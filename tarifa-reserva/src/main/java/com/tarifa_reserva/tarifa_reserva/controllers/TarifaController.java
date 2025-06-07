package com.tarifa_reserva.tarifa_reserva.controllers;

import com.tarifa_reserva.tarifa_reserva.entities.TarifaEntity;
import com.tarifa_reserva.tarifa_reserva.services.TarifaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifas")
@RequiredArgsConstructor
public class TarifaController {
    private final TarifaService tarifaService;

    @GetMapping("/")
    public List<TarifaEntity> getAllTarifas() {
        return tarifaService.obtenerTodasTarifas();
    }

    @PostMapping("/")
    public void updateTarifas(@RequestBody List<TarifaEntity> tarifas) {
        tarifaService.actualizarTarifas(tarifas);
    }
}