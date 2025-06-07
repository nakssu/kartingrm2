package com.dcto_personas.dcto_personas.controllers;

import com.dcto_personas.dcto_personas.services.DescuentoGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dcto-personas")
@RequiredArgsConstructor
public class DescuentoGrupoController {
    private final DescuentoGrupoService descuentoGrupoService;

    @GetMapping("/calcular")
    public int calcularDescuento(@RequestParam("cantidadPersonas") int cantidadPersonas,
                                 @RequestParam("subtotal") int subtotal) {
        return descuentoGrupoService.calcularDescuento(cantidadPersonas, subtotal);
    }
}