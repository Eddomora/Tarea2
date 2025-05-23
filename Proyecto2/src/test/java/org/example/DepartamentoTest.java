package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DepartamentoTest {
    private Departamento d;
    private Empleado e;

    @BeforeEach
    void primero(){
        d = new Departamento("Exploradores");
        e = new Empleado("1","Drake","Nathan", "uncharted@example.com");
        d.agregarEmpleado(e);
    }

    @Test
    void agregarEmpleado() {
        assertTrue(d.getEmpleados().contains(e));
    }

    @Test
    void obtenerCantidadEmpleados() {
        assertEquals(1,d.obtenerCantidadEmpleados());
    }

}