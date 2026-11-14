package com.rumbosur.estrategia;

import com.rumbosur.modelo.Reserva;
import java.time.temporal.ChronoUnit;

public class PromocionAnticipada implements EstrategiaPromocion {
    @Override
    public double calcularDescuento(Reserva reserva, double subtotal) {
        long dias = ChronoUnit.DAYS.between(reserva.getFecha(), reserva.getSalida().getFechaInicio());
        if (dias > 60) {
            return subtotal * 0.15;
        }
        return 0.0;
    }
}