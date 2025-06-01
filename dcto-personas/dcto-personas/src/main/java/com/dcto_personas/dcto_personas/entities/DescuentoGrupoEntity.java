package com.dcto_personas.dcto_personas.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DescuentoGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minPersonas;
    private int maxPersonas;
    private int porcentaje; // porcentaje de descuento (ej: 10 = 10%)

    // Puedes agregar campos para condiciones especiales si lo necesitas
}