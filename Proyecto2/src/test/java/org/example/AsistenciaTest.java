package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {
    @Test
    void ToString() {
        InvitadoExterno persona = new InvitadoExterno("Perez", "Juan", "JP@example.com");
        LocalTime hora = LocalTime.of(8, 45);
        Asistencia asistencia = new Asistencia(persona, EstadoAsistencia.TARDE, hora);

        String esperado = "Juan Perez (08:45 TARDE, JP@example.com)";
        assertEquals(esperado, asistencia.toString());
    }
    @Test
    void SetEstado() {
        InvitadoExterno persona = new InvitadoExterno("Hugo", "Mario", "MH@example.com");
        LocalTime hora = LocalTime.now();
        Asistencia asistencia = new Asistencia(persona, EstadoAsistencia.AUSENTE, hora);

        asistencia.setEstado(EstadoAsistencia.PRESENTE);
        assertEquals(EstadoAsistencia.PRESENTE, asistencia.getEstado());
    }

}