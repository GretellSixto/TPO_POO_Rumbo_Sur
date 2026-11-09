package com.rumbosur.modelo;

public abstract class Persona {
    protected String legajo;
    protected String nombre;
    protected String documento;
    protected String telefono;

    public Persona(String legajo, String nombre, String documento, String telefono) {
        this.legajo = legajo;
        this.nombre =  nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTelefono() { return telefono; }

    public abstract String getDescripcionRol();
}
