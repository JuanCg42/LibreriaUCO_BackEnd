package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.LocalDate;

public class UtilFecha {

    private UtilFecha() {

    }

    public static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }
}