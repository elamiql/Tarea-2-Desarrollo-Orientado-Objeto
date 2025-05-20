package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
        departamento = new Departamento("Oficina");
        empleado = new Empleado("224","Nuñez","Juan","jununez2024@udec");
        Empleado ignacio = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        reunionPresencial = new ReunionPresencial(fecha,horaPrevista,duracionPrevista,ignacio,tipoReunion.MARKETING,"1");
    }

    @test
    public void testGetter(){
        assertequals("224",empleado.getId());
        assertequals("Nuñez",empleado.getApellidos());
        assertequals("Juan",empleado.getNombre());
        assertequals("jununez2024@udec",empleado.getCorreo());
        assertequals(departamento,empleado.getDepartamento());
    }

    @test
    public void testSetter(){
        empleado.setId("324");
        empleado.setApellidos("Guzman");
        empleado.setNombre("Ignacio");
        empleado.setCorreo("Iguzman2024@udec");
        empleado.setDepartamento("ingeneria");
        assertequals("324",empleado.getId());
        assertequals("Guzman",empleado.getApellidos());
        assertequals("Ignacio",empleado.getNombre());
        assertequals("Iguzman2024@udec",empleado.getCorreo());
        assertequals("ingeneria",empleado.getDepartamento());
    }

    @test
    public void testInvitar(){
        String result = empleado.invitar(reunionPresencial);

    }

    @test
    public void testToString(){
        String result = empleado.toString();
        assertequals(result.contains("Empleado "));
        assertequals(result.contains("  id = " + empleado.getId()));
        assertequals(result.contains("  apellidos = " + empleado.getApellidos()));
        assertequals(result.contains("  nombre = " + empleado.getNombre()));
        assertequals(result.contains("  correo = " + empleado.getCorreo()));
        assertequals(result.contains("  departamento = " + departamento));
        assertequals(result.contains("}"));
    }

    @AfterEach
    void tearDown() {
    }
}