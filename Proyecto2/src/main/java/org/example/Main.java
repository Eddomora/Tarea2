package org.example;

import java.time.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Empleado e = new Empleado("1", "Perez Silva", "José", "jperez@udec.cl");

        Departamento d = new Departamento("CFM");
        d.agregarEmpleado(e);

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MAY, 22); // Recuerda: MAY = 4
        Date fecha = cal.getTime();

        LocalDate fechaBase = LocalDate.of(2025, 5, 22);
        LocalTime horaBase = LocalTime.of(20, 0);
        ZoneId zona = ZoneId.systemDefault(); // o usar una zona fija si necesitas consistencia
        Instant horaPresencial = LocalDateTime.of(fechaBase, horaBase).atZone(zona).toInstant();

        Duration duracion = Duration.ofHours(1).plusMinutes(30);

        ReunionPresencial r = new ReunionPresencial(fecha, horaPresencial, duracion, "Auditorio CFM");

        d.invitar();

    }
}