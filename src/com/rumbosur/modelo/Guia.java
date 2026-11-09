package com.rumbosur.modelo;

import java.util.ArrayList;
import java.util.List;

public class Guia extends Persona {
    private List<String> idiomas;
    private List<CategoriaTour> categoriasHabilitadas;
    private double honorarioPorDia;

    public Guia(String legajo, String nombre, String documento, String telefono, double honorarioPorDia) {
        super(legajo,nombre, documento, telefono);
        this.honorarioPorDia = honorarioPorDia;
        this.idiomas = new ArrayList<>();
        this.categoriasHabilitadas = new ArrayList<>();
    }

    public void agregarCategoriaHabilitada(CategoriaTour cat) {
        categoriasHabilitadas.add(cat);
    }

    public boolean estaHabilitadoPara(CategoriaTour cat) {
        return categoriasHabilitadas.contains(cat);
    }

    public double getHonorarioPorDia() {
        return honorarioPorDia;
    }

    @Override
    public String getDescripcionRol() {
        return "Guía Profesional: " + nombre + " (Honorario: ¢" + honorarioPorDia + "/dia)";
    }
}
