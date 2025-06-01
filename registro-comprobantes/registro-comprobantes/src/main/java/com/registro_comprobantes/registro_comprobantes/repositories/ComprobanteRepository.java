package com.registro_comprobantes.registro_comprobantes.repositories;

import com.registro_comprobantes.registro_comprobantes.entities.ComprobanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComprobanteRepository extends JpaRepository<ComprobanteEntity, Long> {
    Optional<ComprobanteEntity> findByReservaId(Long reservaId);
}