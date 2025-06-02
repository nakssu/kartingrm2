package com.reportes.reportes.services;

import com.reportes.reportes.clients.ReservaFeignClient;
import com.reportes.reportes.DTO.IngresoPorVueltasDTO;
import com.reportes.reportes.DTO.IngresoPorPersonasDTO;
import com.reportes.reportes.DTO.ReservaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReporteService {
    private final ReservaFeignClient reservaFeignClient;

    // Reporte: Ingresos por tipo de reserva (ej: 10 vueltas, 15 vueltas, Tiempo Máximo)
    public List<IngresoPorVueltasDTO> reporteIngresosPorVueltas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<ReservaDTO> reservas = reservaFeignClient.getReservasPorFechas(
                fechaInicio.toString(),
                fechaFin.toString()
        );
        // Agrupar por tipo de reserva
        Map<String, List<ReservaDTO>> agrupadoPorTipo = reservas.stream()
                .collect(Collectors.groupingBy(ReservaDTO::getTipoReserva));

        List<IngresoPorVueltasDTO> resultado = new ArrayList<>();
        for (Map.Entry<String, List<ReservaDTO>> entry : agrupadoPorTipo.entrySet()) {
            String tipoReserva = entry.getKey();
            List<ReservaDTO> reservasDeTipo = entry.getValue();

            int cantidadReservas = reservasDeTipo.size();
            int ingresosTotales = reservasDeTipo.stream()
                    .mapToInt(ReservaDTO::getMontoTotal)
                    .sum();

            resultado.add(IngresoPorVueltasDTO.builder()
                    .tipoReserva(tipoReserva)
                    .cantidadReservas(cantidadReservas)
                    .ingresosTotales(ingresosTotales)
                    .build());
        }
        return resultado;
    }

    // Reporte: Ingresos por número de personas
    public List<IngresoPorPersonasDTO> reporteIngresosPorPersonas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<ReservaDTO> reservas = reservaFeignClient.getReservasPorFechas(
                fechaInicio.toString(),
                fechaFin.toString()
        );
        // Agrupar por cantidad de personas (puedes agrupar en rangos si lo deseas)
        Map<Integer, List<ReservaDTO>> agrupadoPorPersonas = reservas.stream()
                .collect(Collectors.groupingBy(ReservaDTO::getCantidadPersonas));

        List<IngresoPorPersonasDTO> resultado = new ArrayList<>();
        for (Map.Entry<Integer, List<ReservaDTO>> entry : agrupadoPorPersonas.entrySet()) {
            int cantidadPersonas = entry.getKey();
            List<ReservaDTO> reservasDeGrupo = entry.getValue();

            int cantidadReservas = reservasDeGrupo.size();
            int ingresosTotales = reservasDeGrupo.stream()
                    .mapToInt(ReservaDTO::getMontoTotal)
                    .sum();

            resultado.add(IngresoPorPersonasDTO.builder()
                    .cantidadPersonas(cantidadPersonas)
                    .cantidadReservas(cantidadReservas)
                    .ingresosTotales(ingresosTotales)
                    .build());
        }
        return resultado;
    }
}

/*
@Service
public class ReporteService {
    public List<IngresoPorVueltasDTO> reporteIngresosPorVueltas() {
        List<IngresoPorVueltasDTO> lista = new ArrayList<>();
        lista.add(IngresoPorVueltasDTO.builder()
                .tipoReserva("10 vueltas")
                .cantidadReservas(15)
                .ingresosTotales(150000)
                .build());
        lista.add(IngresoPorVueltasDTO.builder()
                .tipoReserva("Tiempo Máximo")
                .cantidadReservas(8)
                .ingresosTotales(96000)
                .build());
        return lista;
    }

    public List<IngresoPorPersonasDTO> reporteIngresosPorPersonas() {
        List<IngresoPorPersonasDTO> lista = new ArrayList<>();
        lista.add(IngresoPorPersonasDTO.builder()
                .cantidadPersonas(2)
                .cantidadReservas(10)
                .ingresosTotales(80000)
                .build());
        lista.add(IngresoPorPersonasDTO.builder()
                .cantidadPersonas(4)
                .cantidadReservas(5)
                .ingresosTotales(50000)
                .build());
        return lista;
    }
}

 */