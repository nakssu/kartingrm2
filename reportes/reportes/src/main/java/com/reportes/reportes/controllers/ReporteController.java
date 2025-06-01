package com.reportes.reportes.controllers;

import com.reportes.reportes.DTO.IngresoPorVueltasDTO;
import com.reportes.reportes.DTO.IngresoPorPersonasDTO;
import com.reportes.reportes.services.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {
    private final ReporteService reporteService;

    // Reporte de ingresos por tipo de reserva (número de vueltas o tiempo máximo)
    @GetMapping("/ingresos-vueltas")
    public List<IngresoPorVueltasDTO> reportePorVueltas() {
        return reporteService.reporteIngresosPorVueltas();
    }

    // Reporte de ingresos por número de personas
    @GetMapping("/ingresos-personas")
    public List<IngresoPorPersonasDTO> reportePorPersonas() {
        return reporteService.reporteIngresosPorPersonas();
    }
}