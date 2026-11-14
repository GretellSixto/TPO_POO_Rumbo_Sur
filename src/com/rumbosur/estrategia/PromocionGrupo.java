package com.rumbosur.estrategia;

import com.rumbosur.modelo.Reserva;

public class PromocionGrupo implements EstrategiaPromocion {
    @Override
    public double calcularDescuento(Reserva reserva, double subtotal) {
        if (reserva.getPasajeros().size() >= 6) {
            return subtotal * 0.10;
        }
        return 0.0;
    }
}