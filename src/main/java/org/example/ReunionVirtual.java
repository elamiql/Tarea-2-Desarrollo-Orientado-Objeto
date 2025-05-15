package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * Representa una reunión virtual con un enlace de acceso.
 */
public class ReunionVirtual extends Reunion {

    /**
     * Enlace para acceder a la reunión virtual.
     */
    private String enlace;

    /**
     * Crea una reunión virtual con la información especificada.
     *
     * @param fecha           Fecha de la reunión.
     * @param horaPrevista    Hora prevista de inicio.
     * @param duracionPrevista Duración estimada de la reunión.
     * @param organizador     Empleado que organiza la reunión.
     * @param tipoReunion     Tipo de la reunión.
     * @param enlace          Enlace para la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String enlace){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace = enlace;
    }
    /**
     * Obtiene el enlace de la reunión virtual.
     *
     * @return Enlace de acceso.
     */
    public String getEnlace(){
        return enlace;
    }
    /**
     * Establece el enlace de la reunión virtual.
     *
     * @param enlace Nuevo enlace para la reunión.
     */
    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    /**
     * Devuelve una representación  de la reunión virtual.
     *
     * @return Cadena con detalles de la reunión virtual.
     */
    @Override
    public String toString() {
        return "ReunionVirtual {\n" +
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
                "  enlace = " + getEnlace() + "\n" +
                "}";
    }


}
