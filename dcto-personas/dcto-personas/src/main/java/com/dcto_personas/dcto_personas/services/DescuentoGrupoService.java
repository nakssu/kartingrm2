package com.dcto_personas.dcto_personas.services;

import com.dcto_personas.dcto_personas.entities.DescuentoGrupoEntity;
import com.dcto_personas.dcto_personas.repositories.DescuentoGrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DescuentoGrupoService {
    private final DescuentoGrupoRepository descuentoGrupoRepository;

    public int calcularDescuento(int cantidadPersonas, int subtotal) {
        // Busca el descuento aplicable por la cantidad de personas
        return descuentoGrupoRepository.findByMinPersonasLessThanEqualAndMaxPersonasGreaterThanEqual(cantidadPersonas, cantidadPersonas)
                .map(descuento -> (subtotal * descuento.getPorcentaje()) / 100)
                .orElse(0);
    }

    // Métodos CRUD para administrar descuentos (opcional, para un panel de admin)
}