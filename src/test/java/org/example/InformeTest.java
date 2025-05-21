package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InformeTest {
    ReunionPresencial reunion;
    String nombreArchivo;
    Informe informe;
    Empleado agustin;
    Empleado juanpablo;
    Empleado ignacio;

    @BeforeEach
    void setUp() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);
        agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");
        ignacio = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        informe = new Informe();
        reunion = new ReunionPresencial(fecha,horaPrevista,duracionPrevista,juanpablo,tipoReunion.OTRO,"3");
    }

    @Test
    public void testGenerarInforme() throws IOException {
        reunion.agregarParticipante(agustin);
        reunion.agregarParticipante(ignacio);

        // asistencia
        reunion.registrarAsistencia(agustin, Instant.now());  // asistio a tiempo
        reunion.registrarAsistencia(ignacio, Instant.now().plusSeconds(90));  // retraso

        // nota
        reunion.agregarNota("nota de prueba");

        // crear archivo temporal
        File tempFile = File.createTempFile("informe_test", ".txt");
        tempFile.deleteOnExit();

        // genera informe
        Informe.generarInforme(reunion, tempFile.getAbsolutePath());

        // leer el archivo
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // verificar
        assertTrue(lines.stream().anyMatch(l -> l.contains("INFORME DE REUNIÓN")));
        assertTrue(lines.stream().anyMatch(l -> l.contains("Fecha: " + reunion.getFecha())));
        assertTrue(lines.stream().anyMatch(l -> l.contains("Sala: 3")));
        assertTrue(lines.stream().anyMatch(l -> l.contains("Gómez")));
        assertTrue(lines.stream().anyMatch(l -> l.contains("López")));
        assertTrue(lines.stream().anyMatch(l -> l.contains("Notas de la reunion")));
    }

    @AfterEach
    void tearDown() {
    }
}