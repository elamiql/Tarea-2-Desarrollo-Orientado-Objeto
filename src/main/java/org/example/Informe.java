package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Clase utilitaria para generar informes de reuniones.
 */
class Informe {
    /**
     * Genera un informe de la reunion.
     *
     * @param reunion        Reunión de la que se desea generar el informe.
     * @param nombreArchivo  Nombre del archivo donde se guardará el informe.
     */
    public static void generarinforme(Reunion reunion, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("INFORME DE REUNIÓN");
            writer.println("-------------------");
            writer.println("Fecha: " + reunion.getFecha());
            writer.println("Hora prevista de inicio: " + reunion.getHoraPrevista());
            writer.println("Hora de inicio: " + reunion.getHoraInicio());
            writer.println("Hora de fin: " + reunion.getHoraFin());
            writer.println("Duración: " + reunion.getDuracionPrevista());
            writer.println("Tipo de reunión: " + reunion.getTipoReunion());


            if (reunion instanceof ReunionVirtual rv) {
                writer.println("Enlace: " + rv.getEnlace());
            } else if (reunion instanceof ReunionPresencial rp) {
                writer.println("Sala: " + rp.getSala());
            }
            writer.println("Los participantes son: "+ reunion.getParticipantes());
            writer.println("Retrasos: "+ reunion.obtenerRetrasos());
            writer.println("Las notas son: ");
            List<Nota> notasOrdenadas = new ArrayList<>(reunion.getNotas());
            notasOrdenadas.sort(Comparator.comparing(Nota::getTime));
            for (Nota nota : notasOrdenadas) {
                writer.println(nota.getTime() + " - " + nota.getContenido());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

