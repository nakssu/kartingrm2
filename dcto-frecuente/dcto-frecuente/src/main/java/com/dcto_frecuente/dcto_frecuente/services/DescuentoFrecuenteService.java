package com.dcto_frecuente.dcto_frecuente.services;

import org.springframework.stereotype.Service;

@Service
public class DescuentoFrecuenteService {
    public int calcularDescuento(int visitasMes, int subtotal) {
        if (visitasMes >= 7) return (subtotal * 30) / 100;
        if (visitasMes >= 5) return (subtotal * 20) / 100;
        if (visitasMes >= 2) return (subtotal * 10) / 100;
        return 0;
    }
}
