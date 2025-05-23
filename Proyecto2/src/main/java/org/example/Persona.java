package org.example;

public abstract class Persona {

    private String apellidos;
    private String nombre;
    private String correo;

    public Persona(String apellidos, String nombre, String correo) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    protected Persona() {}

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
