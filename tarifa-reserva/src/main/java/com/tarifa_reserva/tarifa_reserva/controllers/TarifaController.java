package com.tarifa_reserva.tarifa_reserva.controllers;

import com.tarifa_reserva.tarifa_reserva.entities.TarifaEntity;
import com.tarifa_reserva.tarifa_reserva.services.TarifaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifas")
//@RequiredArgsConstructor
public class TarifaController {
    @Autowired
    TarifaService tarifaService;

    @GetMapping("/")
    public ResponseEntity<List<TarifaEntity>> obtenerTarifas() {
        return ResponseEntity.ok(tarifaService.obtenerTodasTarifas());
    }

    @PutMapping("/")
    public ResponseEntity<Void> actualizarTarifas(@RequestBody List<TarifaEntity> tarifas) {
        tarifaService.actualizarTarifas(tarifas);
        return ResponseEntity.ok().build();
    }
}