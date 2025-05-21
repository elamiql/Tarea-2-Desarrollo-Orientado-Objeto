package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ReunionTest {
    private ReunionPresencial reunion;
    Empleado agustin;
    Empleado ignacio;
    Empleado juanpablo;

    @BeforeEach
    void setUp() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);
        agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        ignacio = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");
        reunion = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, agustin, tipoReunion.TECNICA, "Sala 2030");
    }

    @Test
    void testAgregarParticipante() {
        reunion.agregarParticipante(ignacio);
        assertTrue(reunion.getParticipantes().contains(ignacio));
    }

    @Test
    void testIniciarYFinalizarReunion() {
        reunion.iniciar();
        assertNotNull(reunion.getHoraInicio());

        reunion.finalizar();
        assertNotNull(reunion.getHoraFin());

        Duration real = reunion.calcularTiempoReal();
        assertFalse(real.isNegative());
    }

    @Test
    void testRegistrarAsistenciaPuntual() {
        reunion.agregarParticipante(ignacio);
        reunion.setHoraInicio(Instant.now());
        reunion.registrarAsistencia(ignacio, Instant.now());

        List<Empleado> asistencia = reunion.obtenerAsistencia();
        assertTrue(asistencia.contains(ignacio));
    }

    @Test
    void testRegistrarRetraso() {
        reunion.agregarParticipante(juanpablo);
        Instant horaInicio = Instant.now();
        reunion.setHoraInicio(horaInicio);

        // Llegada después de 5 segundos
        reunion.registrarAsistencia(juanpablo, horaInicio.plusSeconds(10));

        List<Empleado> retrasados = reunion.obtenerRetrasos();
        assertTrue(retrasados.contains(juanpablo));
    }

    @Test
    void testObtenerAusencias() {
        reunion.agregarParticipante(ignacio);
        reunion.agregarParticipante(juanpablo);

        reunion.setHoraInicio(Instant.now());
        reunion.registrarAsistencia(ignacio, Instant.now());

        List<Empleado> ausentes = reunion.obtenerAusencias();
        assertTrue(ausentes.contains(juanpablo));
        assertFalse(ausentes.contains(juanpablo));
    }

    @Test
    void testPorcentajeAsistencia() {
        reunion.agregarParticipante(ignacio);
        reunion.agregarParticipante(juanpablo);

        reunion.setHoraInicio(Instant.now());
        reunion.registrarAsistencia(ignacio, Instant.now());

        float porcentaje = reunion.obtenerPorcentajeAsistencia();
        assertEquals(50.0f, porcentaje);
    }

    @Test
    void testAgregarNota() {
        reunion.agregarNota("nota de prueba");
        assertEquals(1, reunion.getNotas().size());
        assertEquals("nota de prueba", reunion.getNotas().get(0).getContenido());
    }

    @AfterEach
    void tearDown() {
    }
}