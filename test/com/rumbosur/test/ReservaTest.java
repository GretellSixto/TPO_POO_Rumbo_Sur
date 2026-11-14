package com.rumbosur.test;

import com.rumbosur.controlador.ControladorReserva;
import com.rumbosur.excepciones.CupoExcedidoException;
import com.rumbosur.excepciones.PasajeroNoAptoException;
import com.rumbosur.modelo.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    @Test
    public void testRechazoPorEdadMinimaEnAventura() {
        Tour aventura = new TourAventura("T-01", "Trekking Extremo", "Desc", 2, 2, 10, 50000.0, 18, "Alto");
        Salida salida = new Salida("S-01", LocalDate.now().plusDays(10), LocalDate.now().plusDays(12), 10, aventura);
        Cliente cliente = new Cliente("30123456", "Ana", "Perez", "111", "ana@gmail.com", "Argentina");

        List<Pasajero> pasajeros = new ArrayList<>();
        pasajeros.add(new Pasajero("Nene", "999", LocalDate.now().minusYears(10), TipoPasajero.MENOR_12, "111", "Ninguna"));

        ControladorReserva ctrl = new ControladorReserva();
        assertThrows(PasajeroNoAptoException.class, () -> {
            ctrl.crearReserva(1, cliente, salida, pasajeros);
        });
    }

    @Test
    public void testConfirmacionConPagoDeSeña30Porciento() throws Exception {
        Tour cultural = new TourCultural("T-02", "Museos y Bodegas", "Desc", 1, 1, 10, 20000.0);
        Salida salida = new Salida("S-02", LocalDate.now().plusDays(30), LocalDate.now().plusDays(31), 10, cultural);
        Cliente cliente = new Cliente("30123456", "Ana", "Perez", "111", "ana@gmail.com", "Argentina");

        List<Pasajero> pasajeros = new ArrayList<>();
        pasajeros.add(new Pasajero("Ana Perez", "30123456", LocalDate.of(1990, 1, 1), TipoPasajero.ADULTO, "111", "Ninguna"));

        ControladorReserva ctrl = new ControladorReserva();
        Reserva res = ctrl.crearReserva(2, cliente, salida, pasajeros);

        assertEquals(EstadoReserva.PENDIENTE, res.getEstado());

        res.registrarPago(res.getTotal() * 0.30, "EFECTIVO");
        assertEquals(EstadoReserva.CONFIRMADA, res.getEstado());
    }
}