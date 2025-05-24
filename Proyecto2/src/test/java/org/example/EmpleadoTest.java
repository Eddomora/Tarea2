package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpleadoTest {
    @Test
    void testConstructor() {
        Empleado empleado = new Empleado("155","Zapata","Josefa","lzapata@udec.cl");
        assertEquals("Zapata", empleado.getApellidos());
        assertEquals("Josefa", empleado.getNombre());
        assertEquals("lzapata@udec.cl", empleado.getCorreo());
    }
    @Test
    void testSetCorreo() {
        Empleado empleado = new Empleado("156", "Ulloa", "Carlos", "carlos@udec.cl");
        empleado.setCorreo("carlos2025@inf.udec.cl");

        assertEquals("carlos2025@inf.udec.cl", empleado.getCorreo());
    }
    @Test
    void testDepartamentoEsNullPorDefecto() {
        Empleado empleado = new Empleado("789", "Gómez", "Ana", "ana@correo.com");
    }
}
