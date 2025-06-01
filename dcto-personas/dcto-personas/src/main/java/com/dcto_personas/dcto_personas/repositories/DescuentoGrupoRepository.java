package com.dcto_personas.dcto_personas.repositories;

import com.dcto_personas.dcto_personas.entities.DescuentoGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescuentoGrupoRepository extends JpaRepository<DescuentoGrupoEntity, Long> {
    Optional<DescuentoGrupoEntity> findByMinPersonasLessThanEqualAndMaxPersonasGreaterThanEqual(int cantidad, int cantidad2);
}