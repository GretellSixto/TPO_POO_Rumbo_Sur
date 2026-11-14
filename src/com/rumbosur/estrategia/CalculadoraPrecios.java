package com.rumbosur.estrategia;

import com.rumbosur.modelo.Pasajero;
import com.rumbosur.modelo.Reserva;
import com.rumbosur.modelo.ServicioAdicional;

public class CalculadoraPrecios {

    public double calcularTotalReserva(Reserva reserva) {
        double baseTour = reserva.getSalida().getTour().getPrecioBase();
        double subtotalPasajeros = 0;

        // Subtotal según franja etaria
        for (Pasajero p : reserva.getPasajeros()) {
            subtotalPasajeros += baseTour * p.getTipo().getFactorTarifa();
        }

        // Adicionales
        double subtotalAdicionales = 0;
        for (ServicioAdicional sa : reserva.getAdicionales()) {
            subtotalAdicionales += sa.getPrecio() * reserva.getPasajeros().size();
        }

        double subtotal = subtotalPasajeros + subtotalAdicionales;

        // Regla RN07: Elegir la promoción más favorable (no se acumulan)
        EstrategiaPromocion promoAnticipada = new PromocionAnticipada();
        EstrategiaPromocion promoGrupo = new PromocionGrupo();

        double descAnticipada = promoAnticipada.calcularDescuento(reserva, subtotal);
        double descGrupo = promoGrupo.calcularDescuento(reserva, subtotal);

        double mayorDescuento = Math.max(descAnticipada, descGrupo);
        return subtotal - mayorDescuento;
    }
}