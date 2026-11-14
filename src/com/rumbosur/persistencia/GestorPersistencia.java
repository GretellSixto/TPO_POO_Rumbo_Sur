package com.rumbosur.persistencia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {
    private static final String ARCHIVO_RESERVAS = "reservas_registradas.txt";

    public static void guardarReservaEnArchivo(long nroReserva, String cliente, double total, String estado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_RESERVAS, true))) {
            bw.write(nroReserva + ";" + cliente + ";" + total + ";" + estado);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al persistir en archivo: " + e.getMessage());
        }
    }

    public static List<String> leerReservasHistoricas() {
        List<String> lineas = new ArrayList<>();
        File file = new File(ARCHIVO_RESERVAS);
        if (!file.exists()) return lineas;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return lineas;
    }
}