package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NotaTest {

    @Test
    void agregarContenido() {
        Nota n = new Nota();
        n.agregarContenido("Prueba de");
        n.agregarContenido("Testeo");
        String propuesto = "Prueba de\nTesteo\n";
        assertEquals(propuesto,n.getContenido());
    }
}