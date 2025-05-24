package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    Departamento departamento;
    Empleado empleado;
    ReunionPresencial reunionPresencial;
    ReunionVirtual reunionVirtual;

    @BeforeEach
    void setUp() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);
        departamento = new Departamento("ingeneria");
        empleado = new Empleado("224","Nuñez","Juan","jununez2024@udec");
        Empleado ignacio = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        reunionPresencial = new ReunionPresencial(fecha,horaPrevista,duracionPrevista,ignacio,tipoReunion.MARKETING,"1");
        empleado.setDepartamento(String.valueOf(departamento));
    }

    @Test
    public void testGetter(){
        assertEquals("224",empleado.getId());
        assertEquals("Nuñez",empleado.getApellidos());
        assertEquals("Juan",empleado.getNombre());
        assertEquals("jununez2024@udec",empleado.getCorreo());
        assertEquals(String.valueOf(departamento), empleado.getDepartamento());
    }

    @Test
    public void testSetter(){
        empleado.setId("324");
        empleado.setApellidos("Guzman");
        empleado.setNombre("Ignacio");
        empleado.setCorreo("Iguzman2024@udec");
        empleado.setDepartamento("ingeneria");
        assertEquals("324",empleado.getId());
        assertEquals("Guzman",empleado.getApellidos());
        assertEquals("Ignacio",empleado.getNombre());
        assertEquals("Iguzman2024@udec",empleado.getCorreo());
        assertEquals("ingeneria",empleado.getDepartamento());
    }

    @Test
    public void testInvitar(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        empleado.invitar(reunionPresencial);

        System.setOut(System.out);

        String output = outContent.toString();
        assertTrue(output.contains("Invitación enviada a Juan vía email: jununez2024@udec"));
        assertTrue(output.contains("reunión del tipo presencial"));
        assertTrue(output.contains("sala: 1"));
    }

    @Test
    public void testToString(){
        String result = empleado.toString();
        assertTrue(result.contains("Empleado "));
        assertTrue(result.contains("  id = " + empleado.getId()));
        assertTrue(result.contains("  apellidos = " + empleado.getApellidos()));
        assertTrue(result.contains("  nombre = " + empleado.getNombre()));
        assertTrue(result.contains("  correo = " + empleado.getCorreo()));
        assertTrue(result.contains("  departamento = " + departamento));
        assertTrue(result.contains("}"));
    }

    @AfterEach
    void tearDown() {
    }
}