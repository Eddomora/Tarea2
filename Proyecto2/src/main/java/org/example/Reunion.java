package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Clase abstracta que representa una reunión y gestiona sus participantes, asistencia y registro.
 */
public abstract class Reunion {
    private Empleado organizador;
    private TipoReunion tipoReu;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    private List<Persona> listaInvitados;
    private List<Asistencia> listaAsistentes;

    public Nota note = new Nota();


    public Reunion(Empleado organizador, TipoReunion tipoReu,Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.organizador = organizador;
        this.tipoReu = tipoReu;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;

        this.listaAsistentes = new ArrayList<Asistencia>();
        this.listaInvitados = new ArrayList<>();

        note.crearArchivo();
    }
    /**
     * Agrega un invitado a la reunión.
     * @param p Persona a invitar
     */
    public void agregarInvitado(Persona p) {
        listaInvitados.add(p);
    }

    public void marcarAsistencia(Persona p){
        Instant ahora = Instant.now();
        Duration tolerancia = Duration.ofMinutes(1);
        Asistencia a = new Asistencia(p, EstadoAsistencia.PRESENTE, LocalTime.now().withNano(0));
        if (ahora.isAfter(horaPrevista.plus(tolerancia))){
            a.setEstado(EstadoAsistencia.TARDE);
        }
    }
    /**
     * Registra la asistencia de una persona con estado y hora de llegada.
     * @param persona Asistente
     * @param estado Estado de asistencia (PRESENTE, AUSENTE, TARDE)
     * @param horaLlegada Hora de llegada
     */
    public void registroAsistencia(Persona persona, EstadoAsistencia estado, LocalTime horaLlegada) {
        listaAsistentes.add(new Asistencia(persona, estado, horaLlegada));
    }
    /**
     * @return Lista de asistencias (presentes y tardes)
     */
    public List<Asistencia> obtenerAsistencias() {
        List<Asistencia> presentes = new ArrayList<>();
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Asistencia a = listaAsistentes.get(i);
            if (a.getEstado() == EstadoAsistencia.PRESENTE || a.getEstado() == EstadoAsistencia.TARDE) {
                presentes.add(a);
            }
        }
        return presentes;
    }
    /**
     * @return Lista de ausencias
     */
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
    /**
     * @return Lista de personas que llegaron tarde
     */
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> atrasos = new ArrayList<>();
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Asistencia a = listaAsistentes.get(i);
            if (a.getEstado() == EstadoAsistencia.TARDE) {
                atrasos.add(a);
            }
        }
        return atrasos;
    }
    /**
     * Convierte una lista de asistencias en una cadena de texto.
     * @param list Lista de objetos Asistencia a convertir
     * @return String formateado con los elementos separados por comas
     * @throws NullPointerException si la lista proporcionada es null
     */
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
    /**
     * @return Numero total de asistentes a la reunión
     */
    public int obtenerTotalAsistencias() {
        return obtenerAsistencias().size();
    }
    /**
     * @return Porcentaje de asistencia de la reunión
     */
    public float obtenerPorcentajeAsistencias(){
        return (float) obtenerTotalAsistencias() / listaInvitados.size() * 100;
    }

    public float calcularTiempoReal(){
        Duration d = Duration.between(horaInicio, horaFinal);
        float t = d.toMinutes();
        return t;
    }
    /**
     * Inicia la reunión registrando la hora actual.
     */
    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    /**
     * Finaliza la reunión registrando la hora actual.
     * Genera un informe detallado.
     * @param tipoReunion Descripción textual del tipo de reunión
     * @param en lugar físico donde se realizó la reunión
     * @throws RuntimeException si ocurre un error al escribir el archivo
     */
    public void finalizar(String tipoReunion, String en){
        this.horaFinal = Instant.now();
        String temporal = note.getContenido();
        note.setContenido("");

        note.agregarContenido(tipoReunion);
        note.agregarContenido("Organizada por " + organizador.getNombre()+ " " + organizador.getApellidos());
        note.agregarContenido("Fecha de realizacion " + fecha + " en" + en );
        note.agregarContenido("La reunion fue enfocada a "+ tipoReu);
        note.agregarContenido("La reunion inicio a las " + horaInicio + " y finalizo a las " + horaFinal);
        note.agregarContenido("La duracion prevista para la reunion era de " + duracionPrevista + " minutos.");
        note.agregarContenido("La duracion real de la reunion fue de " + calcularTiempoReal() + " minutos." );
        note.agregarContenido("Los detalles sobre la participacion a la reunion se desglosa de la siguiente manera.");
        note.agregarContenido("    El porcentaje es de " + obtenerPorcentajeAsistencias() + "%");
        note.agregarContenido("    La cantidad de personas que asistieron es de " + obtenerTotalAsistencias());
        note.agregarContenido("    Las personas que asistieron son: " + listaAString(obtenerAsistencias()));
        note.agregarContenido("    Las personas que faltaron son: " +  listaAString(obtenerAusencias()));
        note.agregarContenido("    Las personas que llegaron tarde son: " +  listaAString(obtenerRetrasos()));
        note.agregarContenido("Las notas dentro de la reunion fueron las siguientes.");
        note.agregarContenido(temporal);

        note.generarInforme();

    }
}