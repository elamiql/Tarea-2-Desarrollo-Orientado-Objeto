package org.example;
import java.time.*;
import java.util.*;

/**
 * Representa una reunión presencial con sala asignada.
 */
public class ReunionPresencial extends Reunion{
    /**
     * Sala donde se llevará a cabo la reunión presencial.
     */
    private String sala;
    /**
     * Crea una reunión presencial con la información especificada.
     *
     * @param fecha           Fecha de la reunión.
     * @param horaPrevista    Hora prevista de inicio.
     * @param duracionPrevista Duración estimada de la reunión.
     * @param organizador     Empleado que organiza la reunión.
     * @param tipoReunion     Tipo de la reunión.
     * @param sala            Sala asignada a la reunión.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String sala){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }
    /**
     * Obtiene la sala asignada para la reunión.
     *
     * @return Sala de la reunión presencial.
     */
    public String getSala(){
        return sala;
    }

    /**
     * Establece la sala asignada para la reunión.
     *
     * @param sala Nueva sala para la reunión presencial.
     */
    public void setSala(String sala){
        this.sala = sala;
    }
    /**
     * Devuelve una representación en cadena de la reunión presencial.
     *
     * @return Cadena con detalles de la reunión presencial.
     */
    @Override
    public String toString() {
        return "ReunionPresencial {\n" +
                "  fecha = " + getFecha() + ",\n" +
                "  horaPrevista = " + getHoraPrevista() + ",\n" +
                "  duracionPrevista = " + getDuracionPrevista() + ",\n" +
               "  horaInicio = " + getHoraInicio() + ",\n" +
                "  horaFin = " + getHoraFin() + ",\n" +
                "  asistencias = " + getAsistencias() + ",\n" +
               "  notas = " + getNotas() + ",\n" +
                "  organizador = " + getOrganizador() + ",\n" +
               "  tipoReunion = " + getTipoReunion() + ",\n" +
                "  participantes = " + getParticipantes() + ",\n" +
                "  sala = " + getSala() + "\n" +
                "}";
    }


}
