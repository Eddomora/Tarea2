package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    ReunionPresencial reunion;

    @BeforeEach
    void setUp() {

        Empleado e1 = new Empleado("1", "Perez Silva", "José", "jperez@udec.cl");
        Empleado e2 = new Empleado("2", "Prieto Soto", "Juan", "jprieto@udec.cl");
        Externo p = new Externo( "Soliz Arriagada", "Carla", "csoliz@udec.cl");

        Departamento d = new Departamento("CFM");
        d.agregarEmpleado(e1);

        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(1);

        Duration duracion = Duration.ofHours(1).plusMinutes(30);

        ReunionPresencial r = new ReunionPresencial(e2, TipoReunion.MARKETING, fecha, horaPrevista, duracion, "Auditorio CFM");

        d.invitar(r);
    }

    @Test
    void registroAsistencia() {

    }

    @Test
    void obtenerAsistencias() {
    }

    @Test
    void obtenerAusencias() {
    }

    @Test
    void obtenerRetrasos() {
    }

    @Test
    void obtenerTotalAsistencias() {
    }

    @Test
    void obtenerPorcentajeAsistencias() {
    }

    @Test
    void calcularTiempoReal() {
    }

    @Test
    void iniciar() {
    }

    @Test
    void finalizar() {
    }
}