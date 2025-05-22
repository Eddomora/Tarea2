package org.example;

import java.time.Instant;

//En esta clase se puede registrar la asistencia de las personas invitadas a la reu
//el estado está dado por el enum EstadoAsistencia que tiene las 3 opciones posibles

public class Asistencia {
    private Persona persona;
    private EstadoAsistencia estado;
    private Instant horaLlegada;

    public Asistencia(Persona persona, EstadoAsistencia estado, Instant horaLlegada) {
        this.persona = persona;
        this.estado = estado;
        this.horaLlegada = horaLlegada;
    }

    public Persona getPersona() {
        return persona;
    }
    public EstadoAsistencia getEstado() {
        return estado;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    public void setEstado(EstadoAsistencia estado){
        this.estado = estado;
    }
}
//asi luego en la clase Reunion podemos registrar facilmente quienes llegaron tarde
// o quienes no llegaron (ausentes).
