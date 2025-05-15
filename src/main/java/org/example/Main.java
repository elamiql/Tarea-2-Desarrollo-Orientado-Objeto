package org.example;

import java.awt.*;
import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Departamento developers = new Departamento("Devs");

        Empleado agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        Empleado ignacio = new Empleado("216", "Silva", "Ignacio", "ignaciosilva2023@udec.cl");
        Empleado juanpablo = new Empleado("215", "Pablo", "Jota pe", "jotape2024@udec.cl");

        developers.agregarEmpleado(agustin);
        developers.agregarEmpleado(ignacio);
        developers.agregarEmpleado(juanpablo);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofMinutes(90);

        ReunionPresencial reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, agustin, tipoReunion.TECNICA, "Sala 2030");

        reunionPresencial.agregarParticipante(developers);

        reunionPresencial.agregarNota("Iniciada la reunion");

        reunionPresencial.iniciar();

        reunionPresencial.registrarAsistencia(agustin, horaPrevista);
        reunionPresencial.registrarAsistencia(ignacio, horaPrevista.plusSeconds(10));
        reunionPresencial.registrarAsistencia(juanpablo, horaPrevista.plusSeconds(10));

        try {
            Thread.sleep(10*1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Interrumpida");
        }

        reunionPresencial.listaNotas();

        reunionPresencial.finalizar();

        Informe.generarInforme(reunionPresencial, "informe_1.txt");

        System.out.println("Participantes: " + reunionPresencial.getParticipantes().size());
        System.out.println("Asistencias: " + reunionPresencial.getAsistencias().size());
        System.out.println("Retrasos: " + reunionPresencial.obtenerRetrasos().size());
    }
}