package org.example;

public class Empleado extends Persona {

    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo) {
        super(id, apellidos, nombre, correo);
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
