package com.tarifa_reserva.tarifa_reserva.services;

import com.tarifa_reserva.tarifa_reserva.entities.ReservaEntity;
import com.tarifa_reserva.tarifa_reserva.entities.TarifaEntity;
import com.tarifa_reserva.tarifa_reserva.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final TarifaService tarifaService;

    public List<ReservaEntity> getReservas() {
        return reservaRepository.findAll();
    }

    public ReservaEntity saveReserva(ReservaEntity reserva) {
        // Determinar tipo de día
        reserva.setTipoDia(determinarTipoDia(reserva.getFechaHoraReserva()));
        // Determinar tarifa base
        int tarifaBase = tarifaService.obtenerTarifaBase(reserva.getTipoDia(), reserva.getTipoReserva());
        reserva.setTarifaBasePorPersona(tarifaBase);
        return reservaRepository.save(reserva);
    }

    private TarifaEntity.TipoDia determinarTipoDia(LocalDateTime fechaHora) {
        DayOfWeek dia = fechaHora.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            return TarifaEntity.TipoDia.FINDE;
        }
        // Aquí podrías agregar lógica para feriados
        return TarifaEntity.TipoDia.NORMAL;
    }

    public int calcularDuracionReserva(TarifaEntity.TipoReserva tipoReserva) {
        return switch (tipoReserva) {
            case VUELTAS_10 -> 10;
            case VUELTAS_15 -> 15;
            case VUELTAS_20 -> 20;
        };
    }
}