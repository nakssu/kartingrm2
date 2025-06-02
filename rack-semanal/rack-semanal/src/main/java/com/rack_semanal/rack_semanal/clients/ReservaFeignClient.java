package com.rack_semanal.rack_semanal.clients;

import com.rack_semanal.rack_semanal.DTO.ReservaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "registro-comprobantes")
public interface ReservaFeignClient {

    @GetMapping("/api/reservas")
    List<ReservaDTO> getReservasByRangoFechas(
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin
    );

    // en caso de que no funcione con la ruta anteriorrr
    @GetMapping("/api/reservas/por-fechas")
    List<ReservaDTO> getReservasPorFechas(
            @RequestParam("inicio") String inicio,
            @RequestParam("fin") String fin
    );

}


