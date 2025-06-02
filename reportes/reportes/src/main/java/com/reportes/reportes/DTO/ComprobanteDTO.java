package com.reportes.reportes.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ComprobanteDTO {
    private Long id;
    private Long reservaId;
    private LocalDateTime fechaEmision;
    private int montoPagado;
    private String correoCliente;
}