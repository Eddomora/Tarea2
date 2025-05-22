package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitar{
    private String nombre;
    List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        if (e != null) {
            empleados.add(e);
        }
    }
    public int cantidadEmpleados(){
        return empleados.size();
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    @Override
    public void invitar() {
        for(Empleado e: empleados){
            Reunion.listaInvitados.add(e);
        }
    }

    @Override
    public void invitar(Reunion r) {
        for(Empleado e: empleados){
            Reunion.listaInvitados.add(e);
        }

    }
}
