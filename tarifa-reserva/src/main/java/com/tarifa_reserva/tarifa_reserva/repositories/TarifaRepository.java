package com.tarifa_reserva.tarifa_reserva.repositories;

import com.tarifa_reserva.tarifa_reserva.entities.TarifaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifaRepository extends JpaRepository<TarifaEntity, Long> {
    TarifaEntity findByTipoDiaAndTipoReserva(TarifaEntity.TipoDia tipoDia, TarifaEntity.TipoReserva tipoReserva);
}