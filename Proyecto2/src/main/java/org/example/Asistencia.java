package org.example;

import java.time.Instant;
/**
 * Representa el registro de asistencia de una persona.
 * Incluye información sobre la persona, su estado de asistencia y la hora de llegada.
 */
public class Asistencia {
    private Persona persona;
    private EstadoAsistencia estado;
    private Instant horaLlegada;
    /**
     * @param persona La persona asociada a esta asistencia.
     * @param estado El estado de la asistencia ("PRESENTE", "AUSENTE" o "TARDE")
     * @param horaLlegada La hora de llegada registrada.
     */
    public Asistencia(Persona persona, EstadoAsistencia estado, Instant horaLlegada) {
        this.persona = persona;
        this.estado = estado;
        this.horaLlegada = horaLlegada;
    }
    /**
     * Genera una representación en formato String de la asistencia.
     * El formato es: "{Nombre} {Apellidos} ({Estado}, {Correo})"
     *
     * @return Una cadena que resume la información de la asistencia.
     */
    @Override
    public String toString() {
        return persona.getNombre() +" "+ persona.getApellidos() + " (" + estado +", " + persona.getCorreo() + ")";
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
