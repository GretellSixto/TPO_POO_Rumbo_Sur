package com.rumbosur.modelo;

import java.time.LocalDate;

public class TourNaturaleza extends Tour {
    public TourNaturaleza(String codigo, String nombre, String descripcion, int duracionDias,
                          int cupoMinimo, int cupoMaximo, double precioBase) {
        super(codigo, nombre, descripcion, duracionDias, CategoriaTour.NATURALEZA, cupoMinimo, cupoMaximo, precioBase);
    }

    @Override
    public boolean validarAptitud(Pasajero pasajero, LocalDate fechaSalida) {
        return true;
    }
}