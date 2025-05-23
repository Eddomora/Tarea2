package org.example;

import org.example.Reunion;
/**
 * Representa a un empleado, extendiendo las propiedades básicas de una persona
 * Se registran datos personales de cada Empleado
 */
public class Empleado extends Persona implements Invitar {

    private String id;
    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo) {

        super(apellidos, nombre, correo);
        this.id = id;
    }
    /**
     * Obtiene el departamento actual del empleado.
     *
     * @return Departamento asociado al empleado.
     */
    public Departamento getDepartamento() {
        return departamento;
    }
    /**
     * Invita al empleado a la reunion.
     *
     * @param r La reunión a la que se invitará al empleado.
     */
    @Override
    public void invitar(Reunion r) {

    }
}
