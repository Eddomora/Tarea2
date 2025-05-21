package org.example;

 metodosReunion
import org.example.Reunion;


 main
public class Empleado extends Persona implements Invitar {

    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo) {
        super(id, apellidos, nombre, correo);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void invitar(){}
}
