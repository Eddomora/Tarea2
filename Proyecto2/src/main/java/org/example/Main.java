package org.example;

import java.time.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Empleado e = new Empleado("1", "Perez Silva", "José", "jperez@udec.cl");
        Empleado e2 = new Empleado("2", "Prieto Soto", "Juan", "jprieto@udec.cl");

        Departamento d = new Departamento("CFM");
        d.agregarEmpleado(e);

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MAY, 22); // Recuerda: MAY = 4 (entendi la referencia)
        Date fecha = cal.getTime();

        LocalDate fechaBase = LocalDate.of(2025, 5, 22);
        LocalTime horaBase = LocalTime.of(20, 0);
        ZoneId zona = ZoneId.systemDefault(); // o usar una zona fija si necesitas consistencia
        Instant horaPresencial = LocalDateTime.of(fechaBase, horaBase).atZone(zona).toInstant();

        Duration duracion = Duration.ofHours(1).plusMinutes(30);

        ReunionPresencial r = new ReunionPresencial(e2, TipoReunion.TECNICA, fecha, horaPresencial, duracion, "Auditorio CFM");

        r.agregarInvitado(e);
        r.agregarInvitado(e2);
        d.invitar(r);
        r.registroAsistencia(e,EstadoAsistencia.PRESENTE,Instant.now());

        r.iniciar();
        r.registroAsistencia(e2,EstadoAsistencia.TARDE,Instant.now());
        r.note.agregarContenido("Pedrito tuvo incoveniencias al llegar a la sala" + "(" + LocalTime.now().withNano(0) + ")");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        r.note.agregarContenido("Pedrito tuvo incoveniencias y tuvo que regresar al baño" + "(" + LocalTime.now().withNano(0) + ")");
        r.finaliza();
    }
}