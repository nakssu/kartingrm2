package com.reportes.reportes.services;

import com.reportes.reportes.DTO.IngresoPorVueltasDTO;
import com.reportes.reportes.DTO.IngresoPorPersonasDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReporteService {

    // Simulación de lógica. En una implementación real, deberías consultar a los microservicios de reservas/comprobantes.
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