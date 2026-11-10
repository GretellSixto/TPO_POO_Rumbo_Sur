package com.rumbosur.modelo;

import java.time.LocalDate;

public abstract class Tour {
    protected String codigo;
    protected String nombre;
    protected String descripcion;
    protected int duracionDias;
    protected CategoriaTour categoria;
    protected int cupoMinimo;
    protected int cupoMaximo;
    protected double precioBase;

    public Tour (String codigo, String nombre, String descripcion, int duracionDias, CategoriaTour categoria, int cupoMinimo, int cupoMaximo, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionDias = duracionDias;
        this.categoria = categoria;
        this.cupoMinimo = cupoMinimo;
        this.cupoMaximo = cupoMaximo;
        this.precioBase = precioBase;
    }

    public abstract boolean validarAptitud(Pasajero pasajero, LocalDate fechaSalida);

    public String getCodigo () { return codigo; }
    public String getNombre () { return nombre; }
    public int getDuracionDias() { return duracionDias; }
    public CategoriaTour getCategoria() { return categoria;
    }

    public int getCupoMinimo() { return cupoMinimo; }
    public int getCupoMaximo() { return cupoMaximo; }
    public double getPrecioBase() { return precioBase; }
}

