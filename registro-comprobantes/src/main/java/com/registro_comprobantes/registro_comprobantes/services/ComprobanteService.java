package com.registro_comprobantes.registro_comprobantes.services;

import com.registro_comprobantes.registro_comprobantes.entities.ComprobanteEntity;
import com.registro_comprobantes.registro_comprobantes.repositories.ComprobanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComprobanteService {
    private final ComprobanteRepository comprobanteRepository;

    public ComprobanteEntity emitirComprobante(Long reservaId, int monto, String correoCliente) {
        ComprobanteEntity comprobante = ComprobanteEntity.builder()
                .reservaId(reservaId)
                .fechaEmision(LocalDateTime.now())
                .montoPagado(monto)
                .correoCliente(correoCliente)
                .build();
        return comprobanteRepository.save(comprobante);
    }

    public Optional<ComprobanteEntity> getByReservaId(Long reservaId) {
        return comprobanteRepository.findByReservaId(reservaId);
    }

    public ComprobanteEntity getById(Long id) {
        return comprobanteRepository.findById(id).orElse(null);
    }
}