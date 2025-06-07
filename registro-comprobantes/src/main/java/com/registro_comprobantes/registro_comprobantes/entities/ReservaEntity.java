package com.registro_comprobantes.registro_comprobantes.entities;

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

    private String nombreCliente;
    private String correoCliente;
    private LocalDateTime fechaHoraReserva;
    private int cantidadPersonas;
    private String tipoReserva; // Ej: "10 vueltas", "15 vueltas", etc.
    private int montoTotal;
}