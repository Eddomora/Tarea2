package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    private ArrayList listaInvitados; //No va acá pero la dejo como prototipo


    public Reunion(Date fecha, Instant horaPre, Duration duracionPre, Instant horaIni, Instant horaFin, String espacio){
        this.fecha = fecha;
        this.horaPrevista = horaPre;
        this.duracionPrevista = duracionPre;
        this.horaInicio = horaIni;
        this.horaFinal = horaFin;
    }

    public List obtenerAsistencias(){return null;}
    public List obtenerAusencias(){return null;}
    public List obtenerRetrasos(){return null;}
    public int obtenerTotalAsistencias(){
        return listaInvitados.toArray().length;
    }
    public float obtenerPorcentajeAsistencias(){
        return 0;
        // Total asistencias / Total invitados
    }
    public float calcularTiempoReal(){
        Duration d = Duration.between(horaInicio, horaFinal);
        float t = d.toMinutes();
        return t;
    }
    public void iniciar(){}
    public void finalizar(){}
    }

