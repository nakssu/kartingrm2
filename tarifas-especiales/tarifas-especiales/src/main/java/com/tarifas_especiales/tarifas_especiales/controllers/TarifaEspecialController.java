package com.tarifas_especiales.tarifas_especiales.controllers;

import com.tarifas_especiales.tarifas_especiales.entities.TarifaEspecialEntity;
import com.tarifas_especiales.tarifas_especiales.services.TarifaEspecialService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarifas-especiales")
@RequiredArgsConstructor
public class TarifaEspecialController {
    private final TarifaEspecialService tarifaEspecialService;

    @GetMapping
    public List<TarifaEspecialEntity> getAll() {
        return tarifaEspecialService.getAll();
    }

    @PostMapping
    public TarifaEspecialEntity createOrUpdate(@RequestBody TarifaEspecialEntity tarifa) {
        return tarifaEspecialService.createOrUpdate(tarifa);
    }

    @GetMapping("/fecha/{fecha}")
    public Optional<TarifaEspecialEntity> getByFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return tarifaEspecialService.getByFecha(fecha);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tarifaEspecialService.deleteById(id);
    }
}