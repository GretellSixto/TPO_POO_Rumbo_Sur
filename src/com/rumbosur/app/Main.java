package com.rumbosur.app;

import com.rumbosur.controlador.ControladorReserva;
import com.rumbosur.excepciones.CupoExcedidoException;
import com.rumbosur.excepciones.PasajeroNoAptoException;
import com.rumbosur.modelo.*;
import com.rumbosur.persistencia.GestorPersistencia;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorReserva controlador = new ControladorReserva();

        // 1. Datos iniciales del catálogo
        Tour tourAventura = new TourAventura("T-01", "Rafting en Cañón del Atuel", "Aventura pura", 3, 2, 10, 80000.0, 14, "Medio");
        Tour tourCultural = new TourCultural("T-02", "Caminos del Vino", "Recorrido histórico y bodegas", 2, 2, 20, 60000.0);

        List<Salida> salidas = new ArrayList<>();
        salidas.add(new Salida("S-101", LocalDate.now().plusDays(40), LocalDate.now().plusDays(43), 10, tourAventura));
        salidas.add(new Salida("S-102", LocalDate.now().plusDays(15), LocalDate.now().plusDays(17), 20, tourCultural));
        salidas.add(new Salida("S-103", LocalDate.now().plusDays(5), LocalDate.now().plusDays(7), 8, tourAventura));

        Cliente cliente = new Cliente("35123456", "Lucas", "Gómez", "11-4567-8901", "lucas@gmail.com", "Argentina");
        List<Reserva> reservasActivas = new ArrayList<>();
        long contadorReservas = 1000;

        System.out.println("==================================================");
        System.out.println("   SISTEMA DE GESTION DE TOURS - RUMBO SUR");
        System.out.println("==================================================");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Listar salidas disponibles (Orden natural por fecha - Comparable)");
            System.out.println("2. Listar salidas ordenadas por cupo disponible (Comparator)");
            System.out.println("3. Crear nueva reserva (CU01)");
            System.out.println("4. Registrar pago de seña/saldo (CU02)");
            System.out.println("5. Cancelar reserva con cálculo de reintegro (CU03)");
            System.out.println("6. Ver historial persistido en archivo");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            String op = scanner.nextLine();
            switch (op) {
                case "1":
                    Collections.sort(salidas); // Usa Comparable
                    System.out.println("\n--- Salidas Cronologicas ---");
                    for (Salida s : salidas) {
                        System.out.println("[" + s.getIdSalida() + "] " + s.getTour().getNombre() +
                                " | Inicio: " + s.getFechaInicio() +
                                " | Cupos: " + s.getCuposReservados() + "/" + s.getCupoMaximo() +
                                " | Estado: " + s.getEstado());
                    }
                    break;

                case "2":
                    // Uso de Comparator requerido por la cátedra
                    salidas.sort(Comparator.comparingInt(s -> (s.getCupoMaximo() - s.getCuposReservados())));
                    System.out.println("\n--- Salidas Ordenadas por Plazas Disponibles ---");
                    for (Salida s : salidas) {
                        int disponibles = s.getCupoMaximo() - s.getCuposReservados();
                        System.out.println("[" + s.getIdSalida() + "] " + s.getTour().getNombre() +
                                " | Plazas libres: " + disponibles);
                    }
                    break;

                case "3":
                    System.out.println("\n--- Nueva Reserva ---");
                    Salida salidaElegida = salidas.get(0); // Tomamos la primera para la demo
                    System.out.println("Reservando para salida: " + salidaElegida.getIdSalida() + " (" + salidaElegida.getTour().getNombre() + ")");

                    List<Pasajero> pasajeros = new ArrayList<>();
                    pasajeros.add(new Pasajero("Lucas Gomez", "35123456", LocalDate.of(1990, 5, 12), TipoPasajero.ADULTO, "1111", "Ninguna"));
                    pasajeros.add(new Pasajero("Tobias Gomez", "55123456", LocalDate.of(2015, 8, 20), TipoPasajero.MENOR_12, "1111", "Asma"));

                    try {
                        Reserva res = controlador.crearReserva(++contadorReservas, cliente, salidaElegida, pasajeros);
                        reservasActivas.add(res);
                        System.out.println(">> ¡Reserva creada con exito! Nro: #" + res.getNumero());
                        System.out.println(">> Total calculado con promociones: $" + res.getTotal());
                        System.out.println(">> Seña requerida del 30%: $" + (res.getTotal() * 0.30));
                    } catch (CupoExcedidoException | PasajeroNoAptoException e) {
                        System.err.println("Error de validacion: " + e.getMessage());
                    } finally {
                        System.out.println("(Verificacion de disponibilidad finalizada)");
                    }
                    break;

                case "4":
                    if (reservasActivas.isEmpty()) {
                        System.out.println("No hay reservas activas en memoria.");
                        break;
                    }
                    Reserva r = reservasActivas.get(0);
                    double seña = r.getTotal() * 0.30;
                    r.registrarPago(seña, "TARJETA");
                    System.out.println(">> Pago de seña registrado por $" + seña);
                    System.out.println(">> Estado actual de la reserva: " + r.getEstado());
                    System.out.println(">> Saldo restante: $" + r.getSaldoPendiente());
                    break;

                case "5":
                    if (reservasActivas.isEmpty()) {
                        System.out.println("No hay reservas activas para cancelar.");
                        break;
                    }
                    Reserva rCancel = reservasActivas.remove(0);
                    NotaDeAjuste nota = controlador.cancelarReserva(rCancel, "Cancelacion solicitada por cliente");
                    System.out.println(">> " + nota);
                    System.out.println(">> Cupos liberados en la salida.");
                    break;

                case "6":
                    System.out.println("\n--- Historial Persistido en Disco ---");
                    List<String> lineas = GestorPersistencia.leerReservasHistoricas();
                    if (lineas.isEmpty()) {
                        System.out.println("El archivo todavia esta vacio.");
                    } else {
                        for (String l : lineas) System.out.println(l);
                    }
                    break;

                case "0":
                    salir = true;
                    System.out.println("Cerrando aplicacion Rumbo Sur.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }
}