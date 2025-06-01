package com.dcto_frecuente.dcto_frecuente.controllers;

import com.dcto_frecuente.dcto_frecuente.services.DescuentoFrecuenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dcto-frecuente")
@RequiredArgsConstructor
public class DescuentoFrecuenteController {
    private final DescuentoFrecuenteService descuentoFrecuenteService;

    @GetMapping("/calcular")
    public int calcularDescuento(@RequestParam("visitasMes") int visitasMes,
                                 @RequestParam("subtotal") int subtotal) {
        return descuentoFrecuenteService.calcularDescuento(visitasMes, subtotal);
    }
}