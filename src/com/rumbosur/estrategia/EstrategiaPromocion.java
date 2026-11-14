package com.rumbosur.estrategia;

import com.rumbosur.modelo.Reserva;

public interface EstrategiaPromocion {
    double calcularDescuento(Reserva reserva, double subtotal);
}