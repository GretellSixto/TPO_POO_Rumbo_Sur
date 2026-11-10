package com.rumbosur.modelo;

import java.time.LocalDate;
import java.time.Period;

public class Pasajero {
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;
    private TipoPasajero tipo;
    private String contactoEmergencia;
    private String restriccionesSalud;

    public Pasajero(String nombre, String documento, LocalDate fechaNacimiento, TipoPasajero tipo, String contactoEmergencia, String restriccionesSalud) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.contactoEmergencia = contactoEmergencia;
        this.restriccionesSalud = restriccionesSalud;
    }

    public int calcularEdad(LocalDate fechaReferencia) {
        return Period.between(fechaNacimiento, fechaReferencia).getYears();
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public TipoPasajero getTipo() { return tipo; }
    public String getContactoEmergencia() { return contactoEmergencia; }
    public String getRestriccionesSalud() { return restriccionesSalud; }
}
