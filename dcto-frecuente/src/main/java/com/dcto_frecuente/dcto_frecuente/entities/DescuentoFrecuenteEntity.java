package com.dcto_frecuente.dcto_frecuente.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DescuentoFrecuenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minVisitas;
    private int maxVisitas;
    private int porcentaje;
}