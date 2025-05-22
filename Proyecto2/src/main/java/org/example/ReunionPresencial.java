package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Empleado organizador, tipoReunion tipoReu, Date fecha, Instant horaPresencial, Duration duracionPresencial, String sala) {
        super(organizador, tipoReu, fecha, horaPresencial, duracionPresencial);
        this.sala = sala;
    }

    public String getSala(){
        return sala;
    }

    public void finaliza(){
        super.finalizar("Reunion Presencial"," la sala "+ getSala());
    }
}
