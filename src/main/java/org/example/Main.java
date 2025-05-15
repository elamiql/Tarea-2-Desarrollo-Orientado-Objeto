package org.example;

import java.time.*;
import java.util.Date;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("123", "Salgado Espinoza", "Agustín", "agsalgado2023@udec.cl");
        System.out.println(e1);
        Asistencia a1 = new Asistencia(e1, true, Instant.now());
        ReunionPresencial reunion = new ReunionPresencial(new Date(), Instant.now(), Duration.of(10,  SECONDS), e1, tipoReunion.MARKETING, "Sala 2023");
        System.out.println(reunion.getFecha());
    }
}