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

class InvitacionTest {
    Invitacion invitacion;
    private Invitable destinatario;
    private Reunion reunion;
    Empleado agustin;
    Empleado juanpablo;

    @BeforeEach
    void setUp() {
        juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");
        agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        destinatario = juanpablo;
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);

        reunion = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, agustin, tipoReunion.TECNICA, "Sala 2030");
        invitacion = new Invitacion(juanpablo,reunion,horaPrevista);
    }

    @Test
    public void testEnviarInvitacio(){
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));
        invitacion.enviarInvitacion();
        System.setOut(salidaOriginal);
        String salida = salidaCapturada.toString();
        assertTrue(salida.contains("Invitación enviada a Jota pe vía email: jotape2024@udec.cl con detalles: Estimado Jota pe Pablo, está invitado a una reunión del tipo presencial en la sala: Sala 2030"));
    }

    @AfterEach
    void tearDown() {
    }
}