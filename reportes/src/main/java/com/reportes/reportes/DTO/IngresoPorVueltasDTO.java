package com.reportes.reportes.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngresoPorVueltasDTO {
    private String tipoReserva; // Ejemplo: "10 vueltas", "15 vueltas", "Tiempo Máximo"
    private int cantidadReservas;
    private int ingresosTotales;
}