package com.reportes.reportes.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngresoPorPersonasDTO {
    private int cantidadPersonas;
    private int cantidadReservas;
    private int ingresosTotales;
}