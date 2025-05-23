package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    ReunionPresencial reunion;
    Empleado e1;
    Empleado e2;

    @BeforeEach
    void setUp() {

        e1 = new Empleado("1", "Perez Silva", "José", "jperez@udec.cl");
        e2= new Empleado("2", "Prieto Soto", "Juan", "jprieto@udec.cl");
        InvitadoExterno p = new InvitadoExterno( "Soliz Arriagada", "Carla", "csoliz@udec.cl");

        Departamento d = new Departamento("CFM");
        d.agregarEmpleado(e1);

        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(1);

        Duration duracion = Duration.ofHours(1).plusMinutes(30);

        reunion = new ReunionPresencial(e2, TipoReunion.MARKETING, fecha, horaPrevista, duracion, "Auditorio CFM");
        reunion.agregarInvitado(e2);
        d.invitar(reunion);
        reunion.registroAsistencia(e2, EstadoAsistencia.PRESENTE, LocalTime.of(9, 0) );
    }


    @Test
    void obtenerAsistencias() {
        assertEquals(1, reunion.obtenerAsistencias().size());
    }

    @Test
    void obtenerAusencias() {
        assertEquals(0,reunion.obtenerAusencias().size());
    }

    @Test
    void obtenerRetrasos() {
        assertEquals(0,reunion.obtenerRetrasos().size());
    }

    @Test
    void obtenerTotalAsistencias() {
        assertEquals(1, reunion.obtenerTotalAsistencias());
    }

    @Test
    void obtenerPorcentajeAsistencias() {
        assertEquals(100,reunion.obtenerPorcentajeAsistencias());
    }


}