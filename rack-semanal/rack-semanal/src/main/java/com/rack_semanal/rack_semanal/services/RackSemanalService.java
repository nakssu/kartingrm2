package com.rack_semanal.rack_semanal.services;

import com.rack_semanal.rack_semanal.DTO.RackOcupacionDTO;
import org.springframework.stereotype.Service;

import com.rack_semanal.rack_semanal.DTO.ReservaDTO;
import com.rack_semanal.rack_semanal.DTO.RackOcupacionDTO;
import com.rack_semanal.rack_semanal.clients.ReservaFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RackSemanalService {
    private final ReservaFeignClient reservaFeignClient;

    public List<RackOcupacionDTO> obtenerRackSemanal(LocalDate semanaInicio) {
        String inicio = semanaInicio.atStartOfDay().toString();
        String fin = semanaInicio.plusDays(6).atTime(LocalTime.MAX).toString();
        List<ReservaDTO> reservas = reservaFeignClient.getReservasPorFechas(inicio, fin); // caso de falla revisar el getReservasByRangoFechas
        return reservas.stream().map(r -> RackOcupacionDTO.builder()
                .inicio(r.getFechaHoraReserva())
                .fin(r.getFechaHoraReserva().plusHours(1))
                .nombreCliente(r.getNombreCliente())
                .tipoReserva(r.getTipoReserva())
                .build()).collect(Collectors.toList());
    }
}

/*
@Service
public class RackSemanalService {

    public List<RackOcupacionDTO> obtenerRackSemanal(LocalDate semanaInicio) {
        List<RackOcupacionDTO> ocupaciones = new ArrayList<>();

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

        return ocupaciones;
    }
}

*/