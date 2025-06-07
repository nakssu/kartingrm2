package com.rack_semanal.rack_semanal.controllers;

import com.rack_semanal.rack_semanal.DTO.RackOcupacionDTO;
import com.rack_semanal.rack_semanal.services.RackSemanalService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rack-semanal")
@RequiredArgsConstructor
public class RackSemanalController {
    private final RackSemanalService rackSemanalService;

    @GetMapping
    public List<RackOcupacionDTO> obtenerRackSemanal(
            @RequestParam("semanaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate semanaInicio) {
        return rackSemanalService.obtenerRackSemanal(semanaInicio);
    }
}