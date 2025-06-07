package com.tarifa_reserva.tarifa_reserva.repositories;

import com.tarifa_reserva.tarifa_reserva.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByFechaHoraReservaBetween(LocalDateTime inicio, LocalDateTime fin);
}