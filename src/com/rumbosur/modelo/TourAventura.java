package com.rumbosur.modelo;

import java.time.LocalDate;

public class TourAventura extends Tour  {
    private int edadMinima;
    private String nivelDificultad;

    public TourAventura(String codigo, String nombre, String descripcion, int duracionDias, int cupoMinimo, int cupoMaximo, double precioBase, int edadMinima, String nivelDificultad) {
        super(codigo, nombre, descripcion, duracionDias, CategoriaTour.AVENTURA, cupoMinimo, cupoMaximo, precioBase);
        this.edadMinima = edadMinima;
        this.nivelDificultad = nivelDificultad;
    }

    @Override
    public boolean validarAptitud(Pasajero pasajero, LocalDate fechaSalida) {
        return pasajero.calcularEdad(fechaSalida) >= edadMinima;
    }

    public int getEdadMinima() { return edadMinima; }
}
