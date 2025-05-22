package org.example;

import org.example.Reunion;

public class Empleado extends Persona implements Invitar {

    private String id;
    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo) {

        super(apellidos, nombre, correo);
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public void invitar(Reunion r) {

    }
}
