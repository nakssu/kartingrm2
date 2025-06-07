package com.tarifas_especiales.tarifas_especiales.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifaEspecialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ejemplo: "Fiestas Patrias", "Navidad"
    private LocalDate fecha; // Día especial
    private int valor; // Tarifa especial para ese día
}
