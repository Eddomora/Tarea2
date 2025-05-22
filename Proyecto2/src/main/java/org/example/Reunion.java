package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Empleado organizador;
    private tipoReunion tipoReu;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    private List listaInvitados;
    private List listaAsistentes;


    public Reunion(Empleado organizador, tipoReunion tipoReu,Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.organizador = organizador;
        this.tipoReu = tipoReu;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;

        this.listaAsistentes = new ArrayList<Asistencia>();
        this.listaInvitados = new ArrayList<>();
    }
    public void agregarInvitado(Persona p) {
        listaInvitados.add(p); // Agrega a un invitado a la lista (puede ser empleado o ext)
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
    //este tostring solo funciona para asistentes hay que revisarlo
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(listaAsistentes);
        return sb.toString();
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

    public void finalizar(String tipoReunion, String en){
        this.horaFinal = Instant.now();
        Nota note = new Nota();
        note.crearArchivo();
        note.agregarContenido(tipoReunion);
        note.agregarContenido("Fecha de realizacion " + fecha + " en " + en );
        note.agregarContenido("La reunion inicio a las " + horaInicio + " y finalizo a las " + horaFinal);
        note.agregarContenido("La duracion de la reunion fue de " + calcularTiempoReal() + "minutos");
        note.agregarContenido("Los detalles sobre la participacion a la reunion se desglosa de la siguiente manera.");
        note.agregarContenido("    El porcentaje es de " + obtenerPorcentajeAsistencias() + "%");
        note.agregarContenido("    La cantidad de asistentes es de " + obtenerTotalAsistencias());
        note.agregarContenido("    Las personas que asistieron son: " + obtenerAsistencias().toString());// falta el to string a perosnas


        note.escribirEnArchivo();

    }
}

