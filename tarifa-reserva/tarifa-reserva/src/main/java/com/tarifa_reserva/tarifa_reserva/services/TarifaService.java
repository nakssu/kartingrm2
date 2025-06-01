package com.tarifa_reserva.tarifa_reserva.services;

import com.tarifa_reserva.tarifa_reserva.entities.TarifaEntity;
import com.tarifa_reserva.tarifa_reserva.repositories.TarifaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarifaService {
    private final TarifaRepository tarifaRepository;

    public int obtenerTarifaBase(TarifaEntity.TipoDia tipoDia, TarifaEntity.TipoReserva tipoReserva) {
        TarifaEntity tarifa = tarifaRepository.findByTipoDiaAndTipoReserva(tipoDia, tipoReserva);
        if (tarifa == null) {
            throw new IllegalStateException("Tarifa no configurada para " + tipoDia + " y " + tipoReserva);
        }
        return tarifa.getValor();
    }

    public List<TarifaEntity> obtenerTodasTarifas() {
        return tarifaRepository.findAll();
    }

    public void actualizarTarifas(List<TarifaEntity> tarifas) {
        tarifaRepository.saveAll(tarifas);
    }
}