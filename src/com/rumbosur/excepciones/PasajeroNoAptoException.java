package com.rumbosur.excepciones;

public class PasajeroNoAptoException extends Exception {
    public PasajeroNoAptoException(String mensaje) {
        super(mensaje);
    }
}