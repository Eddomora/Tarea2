package org.example;
/**
 * Representa a una persona como una entidad abstracta.
 * Se registran datos básicos de cada persona (nombre, apellidos, correo).
 */
public abstract class Persona {

    private String apellidos;
    private String nombre;
    private String correo;
    /**
     * Constructor principal para crear una persona con todos sus datos.
     *
     * @param apellidos Apellidos de la persona.
     * @param nombre Nombre de la persona.
     * @param correo Correo electrónico de la persona.
     */
    public Persona(String apellidos, String nombre, String correo) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    protected Persona() {
        // Constructor vacío para herencia
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
