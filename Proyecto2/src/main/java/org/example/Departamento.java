package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    List<Empleado> empleados;

    public Departamento() {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        //if (e != null)
        empleados.add(e);
    }
    public int cantidadEmpleados(){
        return empleados.size();
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
}
