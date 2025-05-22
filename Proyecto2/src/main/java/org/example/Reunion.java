package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Empleado organizador;
    private TipoReunion tipoReu;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    private List listaInvitados;
    private List listaAsistentes;


    public Reunion(Empleado organizador, TipoReunion tipoReu,Date fecha, Instant horaPrevista, Duration duracionPrevista){
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
    public void marcarAsistencia(Persona p){
        Instant ahora = Instant.now();
        Duration tolerancia = Duration.ofMinutes(1);
        Asistencia a = new Asistencia(p, EstadoAsistencia.PRESENTE, Instant.now());
        if (ahora.isAfter(horaPrevista.plus(tolerancia))){
            a.setEstado(EstadoAsistencia.TARDE);
        }
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

    public String listaAString(List<Asistencia> list){
        StringBuilder listado = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            listado.append(list.get(i));
            if (i==list.size()-1){
                listado.append(".");
                break;
            }
            listado.append(", ");

        }
        return listado.toString();
    }


    public int obtenerTotalAsistencias() {
        return obtenerAsistencias().size();
    }

    public float obtenerPorcentajeAsistencias(){
        return (float) obtenerTotalAsistencias() / listaInvitados.size() * 100;
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
        note.agregarContenido("Organizada por " + organizador.getNombre()+ " " + organizador.getApellidos());
        note.agregarContenido("Fecha de realizacion " + fecha + " en" + en );
        note.agregarContenido("La reunion fue enfocada a "+ tipoReu);
        note.agregarContenido("La reunion inicio a las " + horaInicio + " y finalizo a las " + horaFinal);
        note.agregarContenido("La duracion de la reunion fue de " + calcularTiempoReal() + " minutos");
        note.agregarContenido("Los detalles sobre la participacion a la reunion se desglosa de la siguiente manera.");
        note.agregarContenido("    El porcentaje es de " + obtenerPorcentajeAsistencias() + "%");
        note.agregarContenido("    La cantidad de personas que asistieron es de " + obtenerTotalAsistencias());
        note.agregarContenido("    Las personas que asistieron son: " + listaAString(obtenerAsistencias()));
        note.agregarContenido("    Las personas que faltaron son: " +  listaAString(obtenerAusencias()));
        note.agregarContenido("    Las personas que llegaron tarde son: " +  listaAString(obtenerRetrasos()));


        note.generarInforme();

    }
}

