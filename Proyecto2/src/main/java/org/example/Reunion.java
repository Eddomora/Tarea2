package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    public static ArrayList listaInvitados;
    private ArrayList listaAsistentes;


    public Reunion(Date fecha, Instant horaPre, Duration duracionPre, String espacio){
        this.fecha = fecha;
        this.horaPrevista = horaPre;
        this.duracionPrevista = duracionPre;

        this.listaAsistentes = new ArrayList<>();
        this.listaInvitados = new ArrayList<>();
    }
    public void agregarInvitado(Persona p) {
        listaInvitados.add(p); //agrega a un invitado a la lista (puede ser empleado o ext)
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
    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFinal = Instant.now(); //Aqui debe de registrarse las cosas en notas
    }
}

