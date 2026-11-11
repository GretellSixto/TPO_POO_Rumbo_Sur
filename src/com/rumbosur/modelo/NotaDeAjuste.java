package com.rumbosur.modelo;

import java.time.LocalDate;

public final class NotaDeAjuste {
    private final long nroReserva;
    private final LocalDate fechaEmision;
    private final double importeDevuelto;
    private final String motivo;

    public NotaDeAjuste(long nroReserva, LocalDate fechaEmision, double importeDevuelto, String motivo) {
        this.nroReserva = nroReserva;
        this.fechaEmision = fechaEmision;
        this.importeDevuelto = importeDevuelto;
        this.motivo = motivo;
    }

    public long getNroReserva() { return nroReserva; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public double getImporteDevuelto() { return importeDevuelto; }
    public String getMotivo() { return motivo; }

    @Override
    public String toString() {
        return "NotaDeAjuste [Reserva #" + nroReserva + " | Fecha: " + fechaEmision +
                " | Reintegro: $" + importeDevuelto + " | Motivo: " + motivo + "]";
    }
}