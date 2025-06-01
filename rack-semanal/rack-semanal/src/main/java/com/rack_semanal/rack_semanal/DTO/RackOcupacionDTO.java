package com.rack_semanal.rack_semanal.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RackOcupacionDTO {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private String nombreCliente;
    private String tipoReserva;
}