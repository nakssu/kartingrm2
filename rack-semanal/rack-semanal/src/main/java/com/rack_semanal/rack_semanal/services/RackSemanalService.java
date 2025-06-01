package com.rack_semanal.rack_semanal.services;

import com.rack_semanal.rack_semanal.DTO.RackOcupacionDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RackSemanalService {

    // En una implementación real, aquí consumirías las reservas de otro microservicio por REST
    public List<RackOcupacionDTO> obtenerRackSemanal(LocalDate semanaInicio) {
        // Simulación de datos para la semana
        List<RackOcupacionDTO> ocupaciones = new ArrayList<>();

        // Ejemplo de reservas simuladas
        ocupaciones.add(RackOcupacionDTO.builder()
                .inicio(LocalDateTime.of(semanaInicio, LocalTime.of(10, 0)))
                .fin(LocalDateTime.of(semanaInicio, LocalTime.of(11, 0)))
                .nombreCliente("Juan Pérez")
                .tipoReserva("10 vueltas")
                .build());
        ocupaciones.add(RackOcupacionDTO.builder()
                .inicio(LocalDateTime.of(semanaInicio.plusDays(1), LocalTime.of(12, 0)))
                .fin(LocalDateTime.of(semanaInicio.plusDays(1), LocalTime.of(13, 0)))
                .nombreCliente("Ana Gómez")
                .tipoReserva("15 vueltas")
                .build());
        // ... agrega lógica real aquí

        return ocupaciones;
    }
}