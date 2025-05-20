package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InformeTest {
    ReunionPresencial reunion;
    String nombreArchivo;
    Informe informe;

    @BeforeEach
    void setUp() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);
        Empleado juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");
        informe = new Informe();
        reunion = new ReunionPresencial(fecha,horaPrevista,duracionPrevista,juanpablo,tipoReunion.OTRO,"3");
    }

    @test
    public void testGenerarInforme(){
        informe.generarInforme(reunion,nombreArchivo);
    }

    @AfterEach
    void tearDown() {
    }
}