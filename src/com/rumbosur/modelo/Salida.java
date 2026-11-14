package com.rumbosur.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Salida implements Comparable<Salida> {
    private String idSalida;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoSalida estado;
    private int cupoMaximo;
    private int cuposReservados;
    private Tour tour;
    private Guia guia;
    private Vehiculo vehiculo;

    public Salida(String idSalida, LocalDate fechaInicio, LocalDate fechaFin, int cupoMaximo, Tour tour) {
        this.idSalida = idSalida;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cupoMaximo = cupoMaximo;
        this.cuposReservados = 0;
        this.tour = tour;
        this.estado = EstadoSalida.PROGRAMADA;
    }

    public boolean hayCupoDisponible(int cantidad) {
        return (cuposReservados + cantidad) <= cupoMaximo && estado != EstadoSalida.CANCELADA;
    }

    public void reservarLugares(int cantidad) {
        this.cuposReservados += cantidad;
        if (cuposReservados >= cupoMaximo) {
            this.estado = EstadoSalida.COMPLETA;
        } else if (cuposReservados >= tour.getCupoMinimo() && estado == EstadoSalida.PROGRAMADA) {
            this.estado = EstadoSalida.CONFIRMADA;
        }
    }

    public void liberarLugares(int cantidad) {
        this.cuposReservados = Math.max(0, this.cuposReservados - cantidad);
        if (this.estado == EstadoSalida.COMPLETA) {
            this.estado = EstadoSalida.CONFIRMADA;
        }
    }

    public long diasHastaInicio(LocalDate hoy) {
        return ChronoUnit.DAYS.between(hoy, fechaInicio);
    }

    @Override
    public int compareTo(Salida otra) {
        return this.fechaInicio.compareTo(otra.fechaInicio); // Orden natural cronológico
    }

    public String getIdSalida() { return idSalida; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public Tour getTour() { return tour; }
    public EstadoSalida getEstado() { return estado; }
    public int getCupoMaximo() { return cupoMaximo; }
    public int getCuposReservados() { return cuposReservados; }
    public void setEstado(EstadoSalida estado) { this.estado = estado; }
    public void setGuia(Guia guia) { this.guia = guia; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public Guia getGuia() { return guia; }
}