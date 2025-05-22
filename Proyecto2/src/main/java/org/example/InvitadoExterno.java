package org.example;

public class InvitadoExterno extends Persona implements Invitar {

    public InvitadoExterno(String id, String apellidos, String nombre, String correo) {
        super(apellidos, nombre, correo);
    }


    @Override
    public void invitar(Reunion r) {

    }
}
