package com.tarifa_reserva.tarifa_reserva.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDia tipoDia; // NORMAL, FINDE, FERIADO

    @Enumerated(EnumType.STRING)
    private TipoReserva tipoReserva; // VUELTAS_10, VUELTAS_15, VUELTAS_20

    private int valor; // valor de la tarifa

    public enum TipoDia {
        NORMAL, FINDE, FERIADO
    }

    public enum TipoReserva {
        VUELTAS_10, VUELTAS_15, VUELTAS_20
    }
}