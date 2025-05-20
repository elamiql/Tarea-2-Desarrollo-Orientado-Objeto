package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class AsistenciaTest {

    Empleado empleado;
    Instant horallegada;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("555","nunez","Juan","jununez@udec");
        horallegada = Instant.now();
    }

    @Test
    public void testgetter(){
        Asistencia asistencia = new Asistencia(empleado,true,horallegada);
        assertEquals(empleado,asistencia.getEmpleado());
        assertTrue(asistencia.getAsistio());
        assertEquals(horallegada,asistencia.getHoraLLegada());
    }

    @Test
    public void testsetter(){
        Asistencia asistencia = new Asistencia(empleado, false, null);
        Empleado nuevoEmpleado = new Empleado("532","Guzman","Ignacio","Iguzman@udec");
        Instant nuevaHora = Instant.now();

        asistencia.setEmpleado(nuevoEmpleado);
        asistencia.setAsistio(true);
        asistencia.setHoraLLegada(nuevaHora);

        assertEquals(nuevoEmpleado, asistencia.getEmpleado());
        assertTrue(asistencia.getAsistio());
        assertEquals(nuevaHora, asistencia.getHoraLLegada());
    }

    @Test
    public void testToString() {
        Asistencia asistencia = new Asistencia(empleado, true, horallegada);
        String result = asistencia.toString();

        assertTrue(result.contains("empleado = " + empleado.toString()));
        assertTrue(result.contains("horaLLegada = " + horallegada.toString()));
        assertTrue(result.contains("asistio = true"));
    }

    @Test
    public void testAsistenciaSinLlegada() {
        Asistencia asistencia = new Asistencia(empleado, false, null);

        assertEquals(empleado, asistencia.getEmpleado());
        assertFalse(asistencia.getAsistio());
        assertNull(asistencia.getHoraLLegada());
    }

    @AfterEach
    void tearDown() {
    }
}