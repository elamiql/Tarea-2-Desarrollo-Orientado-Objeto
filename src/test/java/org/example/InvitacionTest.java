package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    Invitacion invitacion;

    @BeforeEach
    void setUp() {
        Empleado juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");
        Empleado agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, agustin, tipoReunion.TECNICA, "Sala 2030");
        invitacion = new Invitacion(juanpablo,reunionPresencial,horaPrevista);
    }

    @test
    public void testEnviarInvitacio(){
        invitacion.enviarInvitacion();
    }

    @AfterEach
    void tearDown() {
    }
}