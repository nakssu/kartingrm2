package com.reportes.reportes.clients;

import com.reportes.reportes.DTO.ComprobanteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "registro-comprobantes")
public interface ComprobanteFeignClient {
    @GetMapping("/api/comprobantes")
    List<ComprobanteDTO> getAllComprobantes();
}