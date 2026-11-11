package com.rumbosur.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reserva {
    private long numero;
    private LocalDate fecha;
    private EstadoReserva estado;
    private double total;
    private Cliente cliente;
    private Salida salida;
    private List<Pasajero> pasajeros;
    private List<ServicioAdicional> adicionales;
    private List<Pago> pagos;

    public Reserva(long numero, LocalDate fecha, Cliente cliente, Salida salida) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.salida = salida;
        this.estado = EstadoReserva.PENDIENTE;
        this.pasajeros = new ArrayList<>();
        this.adicionales = new ArrayList<>();
        this.pagos = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarPasajero(Pasajero p) {
        pasajeros.add(p);
    }

    public void agregarServicioAdicional(ServicioAdicional sa) {
        adicionales.add(sa);
    }

    public Pago registrarPago(double monto, String medio) {
        Pago pago = new Pago("PAG-" + System.currentTimeMillis(), LocalDate.now(), monto, medio);
        pagos.add(pago);
        if (getTotalAbonado() >= (total * 0.30) && estado == EstadoReserva.PENDIENTE) {
            this.estado = EstadoReserva.CONFIRMADA;
        }
        return pago;
    }

    public double getTotalAbonado() {
        double abonado = 0;
        for (Pago p : pagos) abonado += p.getImporte();
        return abonado;
    }

    public double getSaldoPendiente() {
        return Math.max(0, total - getTotalAbonado());
    }

    public long getNumero() { return numero; }
    public LocalDate getFecha() { return fecha; }
    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public Salida getSalida() { return salida; }
    public Cliente getCliente() { return cliente; }
    public List<Pasajero> getPasajeros() { return Collections.unmodifiableList(pasajeros); }
    public List<ServicioAdicional> getAdicionales() { return Collections.unmodifiableList(adicionales); }
}