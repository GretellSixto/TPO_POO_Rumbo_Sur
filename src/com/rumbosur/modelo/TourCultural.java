package com.rumbosur.modelo;

import java.time.LocalDate;

public class TourCultural extends Tour {
    public TourCultural(String codigo, String nombre, String descripcion, int duracionDias,
                        int cupoMinimo, int cupoMaximo, double precioBase) {
        super(codigo, nombre, descripcion, duracionDias, CategoriaTour.CULTURAL, cupoMinimo, cupoMaximo, precioBase);
    }

    @Override
    public boolean validarAptitud(Pasajero pasajero, LocalDate fechaSalida) {
        return true; // Apto todo publico
    }
}