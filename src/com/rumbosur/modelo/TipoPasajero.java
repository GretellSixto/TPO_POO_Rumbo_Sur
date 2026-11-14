package com.rumbosur.modelo;

public enum TipoPasajero {
    ADULTO(1.0),
    MENOR_12(0.6),
    MENOR_3(0.0),
    JUBILADO(0.9);

    private final double factorTarifa;

    TipoPasajero(double factorTarifa) {
        this.factorTarifa = factorTarifa;
    }

    public double getFactorTarifa() {
        return factorTarifa;
    }
}
