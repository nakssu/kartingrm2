package com.tarifas_especiales.tarifas_especiales.services;

import com.tarifas_especiales.tarifas_especiales.entities.TarifaEspecialEntity;
import com.tarifas_especiales.tarifas_especiales.repositories.TarifaEspecialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarifaEspecialService {
    private final TarifaEspecialRepository tarifaEspecialRepository;

    public List<TarifaEspecialEntity> getAll() {
        return tarifaEspecialRepository.findAll();
    }

    public TarifaEspecialEntity createOrUpdate(TarifaEspecialEntity tarifa) {
        return tarifaEspecialRepository.save(tarifa);
    }

    public Optional<TarifaEspecialEntity> getByFecha(LocalDate fecha) {
        return tarifaEspecialRepository.findByFecha(fecha);
    }

    public void deleteById(Long id) {
        tarifaEspecialRepository.deleteById(id);
    }
}