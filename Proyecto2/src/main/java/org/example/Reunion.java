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
    //lo siguiente es hacer de listaAsistentes como una lista de listas usando la clase Asistencia
    public void registroAsistencia(Persona persona, EstadoAsistencia estado, Instant horaLlegada) {
        listaAsistentes.add(new Asistencia(persona, estado, horaLlegada));
    }
    //obtenerAsistenica crea una lista "vacía" llamada presentes. Luego recorre la lista de invitados y aquellos que llegaron
    //ya sea puntual o tarde son agregados a "presentes".
    public List<Asistencia> obtenerAsistencias() {
        List<Asistencia> presentes = new ArrayList<>();
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Asistencia a = (Asistencia) listaAsistentes.get(i); //no entendi porque intellij me aconsejó el casting pero asi no marca error almenos
            if (a.getEstado() == EstadoAsistencia.PRESENTE || a.getEstado() == EstadoAsistencia.TARDE) {
                presentes.add(a);
            }
        }
        return presentes;
    }
    //para obtenerAusencias se usa la misma mecanica que en obtenerAsistencias.
    public List<Asistencia> obtenerAusencias(){
        List<Asistencia> ausentes = new ArrayList<>();
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Asistencia a = (Asistencia) listaAsistentes.get(i);
            if (a.getEstado() == EstadoAsistencia.AUSENTE) {
                ausentes.add(a);
            }
        }
        return ausentes;
    }
    //same
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> atrasos = new ArrayList<>();
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Asistencia a = (Asistencia) listaAsistentes.get(i);
            if (a.getEstado() == EstadoAsistencia.TARDE) {
                atrasos.add(a);
            }
        }
        return atrasos;
    }

    public int obtenerTotalAsistencias() {
        return listaInvitados.toArray().length;
        //Quiza aqui hay que trabajar con obtenerAsistencia porque queremos el Total de asistencias y listaInvitados ...
    }   //...nos va a entregar el numero total de invitados, no de asistentes.

    public float obtenerPorcentajeAsistencias(){
        float porcentaje = obtenerTotalAsistencias() / listaInvitados.size() * 100;
        return porcentaje;
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

