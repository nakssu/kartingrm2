package com.reportes.reportes.clients;

import com.reportes.reportes.DTO.ReservaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "registro-comprobantes")
public interface ReservaFeignClient {
    @GetMapping("/api/reservas")
    List<ReservaDTO> getReservas(
            @RequestParam(value = "fechaInicio", required = false) String fechaInicio,
            @RequestParam(value = "fechaFin", required = false) String fechaFin
    );
}