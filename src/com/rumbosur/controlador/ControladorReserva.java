package com.rumbosur.controlador;

import com.rumbosur.estrategia.CalculadoraPrecios;
import com.rumbosur.excepciones.CupoExcedidoException;
import com.rumbosur.excepciones.PasajeroNoAptoException;
import com.rumbosur.modelo.*;
import com.rumbosur.persistencia.GestorPersistencia;

import java.time.LocalDate;
import java.util.List;

public class ControladorReserva {
    private CalculadoraPrecios calculadora = new CalculadoraPrecios();

    public Reserva crearReserva(long nro, Cliente cliente, Salida salida, List<Pasajero> pasajeros)
            throws CupoExcedidoException, PasajeroNoAptoException {

        // 1. Validar cupos
        if (!salida.hayCupoDisponible(pasajeros.size())) {
            throw new CupoExcedidoException("No hay cupos suficientes para " + pasajeros.size() + " pasajeros.");
        }

        // 2. Validar aptitud de cada pasajero polimórficamente
        for (Pasajero p : pasajeros) {
            if (!salida.getTour().validarAptitud(p, salida.getFechaInicio())) {
                throw new PasajeroNoAptoException("El pasajero " + p.getNombre() + " no cumple las condiciones de aptitud (edad mínima).");
            }
        }

        // 3. Crear y armar reserva
        Reserva reserva = new Reserva(nro, LocalDate.now(), cliente, salida);
        for (Pasajero p : pasajeros) {
            reserva.agregarPasajero(p);
        }

        // Si es aventura, seguro obligatorio (RN08)
        if (salida.getTour().getCategoria() == CategoriaTour.AVENTURA) {
            reserva.agregarServicioAdicional(new ServicioAdicional("Seguro Obligatorio de Aventura", 5000.0, true));
        }

        // 4. Calcular precio final y reservar cupos
        double total = calculadora.calcularTotalReserva(reserva);
        reserva.setTotal(total);
        salida.reservarLugares(pasajeros.size());

        // 5. Persistir
        GestorPersistencia.guardarReservaEnArchivo(nro, cliente.getNombreCompleto(), total, reserva.getEstado().name());

        return reserva;
    }

    public NotaDeAjuste cancelarReserva(Reserva reserva, String motivo) {
        Salida salida = reserva.getSalida();
        long diasRestantes = salida.diasHastaInicio(LocalDate.now());
        double abonado = reserva.getTotalAbonado();
        double reintegro = 0.0;

        // Escala de cancelación RN10
        if (diasRestantes >= 30) {
            reintegro = abonado * 0.90;
        } else if (diasRestantes >= 15) {
            reintegro = abonado * 0.50;
        } else if (diasRestantes >= 7) {
            reintegro = abonado * 0.20;
        } else {
            reintegro = 0.0;
        }

        reserva.setEstado(EstadoReserva.ANULADA);
        salida.liberarLugares(reserva.getPasajeros().size());

        return new NotaDeAjuste(reserva.getNumero(), LocalDate.now(), reintegro, motivo);
    }
}