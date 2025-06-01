package com.registro_comprobantes.registro_comprobantes.repositories;

import com.registro_comprobantes.registro_comprobantes.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
}