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
public class Informe {

    /**
     * Genera un informe de la reunion.
     *
     * @param reunion        Reunión de la que se desea generar el informe.
     * @param nombreArchivo  Nombre del archivo donde se guardará el informe.
     */
    public static void generarInforme(Reunion reunion, String nombreArchivo) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("INFORME DE REUNIÓN");
            writer.println();
            writer.println("Fecha: " + reunion.getFecha());
            writer.println("Hora prevista de inicio: " + reunion.getHoraPrevista());
            writer.println("Hora de inicio: " + reunion.getHoraInicio());
            writer.println("Hora de fin: " + reunion.getHoraFin());
            writer.println("Duración: " + reunion.getDuracionPrevista().toHoursPart() + " hora y " + reunion.getDuracionPrevista().toMinutesPart() + " minutos.");
            writer.println("Tipo de reunión: " + reunion.getTipoReunion());
            writer.write("Modalidad: ");

            if (reunion instanceof ReunionPresencial){
                writer.write("Presencial\n");
            } else if (reunion instanceof ReunionVirtual){
                writer.write("Virtual\n");
            }
            else{
                writer.write("\n");
            }

            if (reunion instanceof ReunionVirtual rv) {
                writer.println("Enlace: " + rv.getEnlace());
            } else if (reunion instanceof ReunionPresencial rp) {
                writer.println("Sala: " + rp.getSala());
            }

            writer.println();
            writer.write("Lista de participantes: \n");

            List<Asistencia> empleadosAsistentes = reunion.getAsistencias();

            for (Asistencia asistencia : empleadosAsistentes){
                if (asistencia.getAsistio()){
                    Empleado empleado = asistencia.getEmpleado();
                    writer.write(" - Nombre : " + empleado.getNombre() + "   Apellido : " + empleado.getApellidos() + "   Correo : " +empleado.getCorreo() + "   Departamento : " +empleado.getDepartamento() +"\n");
                }
            }

            writer.write("\n");

            writer.write("Lista de retrasos: \n");

            List<Empleado> retrasados = reunion.obtenerRetrasos();

            for (Empleado empleado : retrasados) {
                for (Asistencia asistencia : reunion.getAsistencias()) {
                    if (asistencia instanceof Retraso && asistencia.getEmpleado().equals(empleado)) {
                        Retraso retraso = (Retraso) asistencia;
                        long horas2 = retraso.getDuracionRetraso().toHoursPart();
                        long minutos2 = retraso.getDuracionRetraso().toMinutesPart();
                        long segundos2 = retraso.getDuracionRetraso().toSecondsPart();
                        long minutoss = retraso.getDuracionRetraso().toMinutes();
                        long segundoss = retraso.getDuracionRetraso().toSeconds();

                        if (segundoss < 60) {
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellidos() + " se ha retrasado " + segundos2 +" segundos\n");
                            System.out.println("aca");
                        } else if (minutoss < 60){
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellidos() + " se ha retrasado " + minutos2 +" minutos " + segundos2 +" segundos\n");
                        } else {
                            writer.write(" - El empleado " + empleado.getNombre() + " " + empleado.getApellidos() + " se ha retrasado " + horas2 + " horas " + minutos2 +" minutos " + segundos2 +" segundos\n");
                        }
                        break;
                    }
                }
            }

            writer.write("\n");

            writer.write("Lista de  ausentes: \n");
            List<Empleado> empleadosAusentes = reunion.obtenerAusencias();

            for (Empleado empleado : empleadosAusentes) {
                writer.write(" - Nombre : " + empleado.getNombre() + "   Apellido : " + empleado.getApellidos() + "   Correo : " +empleado.getCorreo() + "   Departamento : " +empleado.getDepartamento() +"\n");
            }
            writer.write("\n\n");

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