package com.registro_comprobantes.registro_comprobantes.services;

import com.registro_comprobantes.registro_comprobantes.entities.ReservaEntity;
import com.registro_comprobantes.registro_comprobantes.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaEntity registrarReserva(ReservaEntity reserva) {
        return reservaRepository.save(reserva);
    }

    public List<ReservaEntity> getAllReservas() {
        return reservaRepository.findAll();
    }

    public ReservaEntity getReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }
}