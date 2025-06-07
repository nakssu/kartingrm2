package com.rack_semanal.rack_semanal.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservaDTO {
    private Long id;
    private String nombreCliente;
    private String tipoReserva;
    private int cantidadPersonas;
    //private int montoTotal;
    private LocalDateTime fechaHoraReserva;
}