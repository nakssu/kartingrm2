package com.tarifa_reserva.tarifa_reserva.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraReserva;
    private String nombreCliente;
    private String correoCliente;
    private int cantidadPersonas;

    @Enumerated(EnumType.STRING)
    private TarifaEntity.TipoReserva tipoReserva;

    @Enumerated(EnumType.STRING)
    private TarifaEntity.TipoDia tipoDia;

    private int tarifaBasePorPersona;
}