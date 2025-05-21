package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("ingeneria");
    }

    @Test
    void testAgregarEmpleado() {
        Empleado empleado = new Empleado("223","Nuñez","Juan","jununez2024@udec");
        departamento.agregarEmpleado(empleado);

        assertEquals(1, departamento.obtenerCantidadEmpleados());
        assertTrue(departamento.getEmpleados().contains(empleado));
        assertEquals("ingeneria", empleado.getDepartamento());
    }

    @Test
    void testObtenerCantidadEmpleados() {
        assertEquals(0, departamento.obtenerCantidadEmpleados());

        departamento.agregarEmpleado(new Empleado("223","Nuñez","Juan","jununez2024@udec"));
        departamento.agregarEmpleado(new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl"));

        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testInvitar() {
        Empleado emp1 = new Empleado("223","Nuñez","Juan","jununez2024@udec");
        Empleado emp2 = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        Empleado agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        departamento.agregarEmpleado(emp1);
        departamento.agregarEmpleado(emp2);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, agustin, tipoReunion.TECNICA, "Sala 2030");

        departamento.invitar(reunionPresencial);
        List<Invitable> participantes = reunionPresencial.getParticipantes();
        assertEquals(2, participantes.size());
        assertTrue(participantes.contains(emp1));
        assertTrue(participantes.contains(emp2));
    }

    @AfterEach
    void tearDown() {
    }
}