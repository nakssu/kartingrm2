package com.tarifas_especiales.tarifas_especiales.repositories;

import com.tarifas_especiales.tarifas_especiales.entities.TarifaEspecialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TarifaEspecialRepository extends JpaRepository<TarifaEspecialEntity, Long> {
    Optional<TarifaEspecialEntity> findByFecha(LocalDate fecha);
}