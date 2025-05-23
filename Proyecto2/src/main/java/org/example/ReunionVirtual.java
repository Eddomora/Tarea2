package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * Representa una Reunión virtual expandiendo las propiedades de una Reunión.
 * Agrega un enlace para realizar la reunion de forma virtual.
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Empleado organizador, TipoReunion tipoReu, Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(organizador, tipoReu, fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
        super.iniciar();
    }

    public String getEnlace(){
        return enlace;
    }

    public void finaliza(){
        super.finalizar("Reunion Virtual"," el link" + getEnlace());
    }
}
