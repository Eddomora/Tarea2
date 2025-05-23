package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa un departamento al que los empleados pueden pertenecer
 * Permite gestionar la lista de empleados y realizar invitaciones.
 */
public class Departamento implements Invitar{
    private String nombre;
    List<Empleado> empleados;
    /**
     * Crea un nuevo departamento con el nombre especificado.
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    /**
     * Agrega un empleado al departamento
     * @param e El empleado que se desea agregar
     */
    public void agregarEmpleado(Empleado e) {
        if (e != null) {
            empleados.add(e);
        }
    }
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<Empleado>(empleados);
    }

    /**
     * Invita a todos los empleados del departamento.
     *
     * @param r La reunión a la que se invitará a los empleados.
     */
    @Override
    public void invitar(Reunion r) {
    }
}
