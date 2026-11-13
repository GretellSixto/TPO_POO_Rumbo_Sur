package com.rumbosur.modelo;

public class Cliente extends Persona {
    private String apellido;
    private String email;
    private String paisResidencia;

    public Cliente(String documento, String nombre, String apellido, String telefono, String email, String paisResidencia) {
        super(documento, nombre, documento, telefono);
        this.apellido = apellido;
        this.email = email;
        this.paisResidencia = paisResidencia;
    }

    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getPaisResidencia() { return paisResidencia; }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String getDescripcionRol() {
        return "Cliente: " + nombre + " " + apellido;
    }
}