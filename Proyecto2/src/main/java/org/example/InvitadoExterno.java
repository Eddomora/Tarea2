package org.example;
/**
 * Representa a un Invitado externo. (No empleado)
 * extiende las características básicas de una persona.
 */
public class InvitadoExterno extends Persona implements Invitar {

    public InvitadoExterno(String id, String apellidos, String nombre, String correo) {
        super(apellidos, nombre, correo);
    }

    /**
     * Invita al externo a la reunión.
     *
     * @param r La reunión a la que se invitará al externo.
     */
    @Override
    public void invitar(Reunion r) {

    }
}
