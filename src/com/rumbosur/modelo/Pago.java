package com.rumbosur.modelo;

import java.time.LocalDate;

public class Pago {
    private String idTransaccion;
    private LocalDate fecha;
    private double importe;
    private String medioPago;

    public Pago(String idTransaccion, LocalDate fecha, double importe, String medioPago) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.importe = importe;
        this.medioPago = medioPago;
    }

    public double getImporte() { return importe; }
    public LocalDate getFecha() { return fecha; }
    public String getMedioPago() { return medioPago; }
}