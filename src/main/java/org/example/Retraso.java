package org.example;
import java.time.*;
/**
 * Clase que representa un registro de retraso de un empleado.
 */
public class Retraso extends Asistencia{
    /**
     * Duración del retraso.
     */
    private Duration duracionRetraso;
    /**
     * Crea un registro de retraso para un empleado.
     *
     * @param empleado     Empleado al cual se le evalua retraso.
     * @param horadeLLegada Hora exacta en que el empleado llegó.
     * @param horaInicio   Hora programada de inicio.
     */
    public Retraso(Empleado empleado, Instant horadeLLegada, Instant horaInicio) {
        super(empleado, true, horaInicio);
        this.duracionRetraso = Duration.between(horaInicio, horadeLLegada);
    }

    /**
     * Devuelve una representación del retraso.
     *
     * @return Cadena con la duración del retraso.
     */
    @Override
    public String toString() {
        return "Retraso{duracionRetraso=" + duracionRetraso + "}";
    }
    /**
     * Obtiene la duración del retraso.
     *
     * @return Duración del retraso.
     */
    public Duration getDuracionRetraso(){
        return duracionRetraso;
    }
    /**
     * Establece la duración del retraso.
     *
     * @param duracionRetraso Nueva duración del retraso.
     */
    public void setDuracionRetraso(Duration duracionRetraso){
        this.duracionRetraso = duracionRetraso;
    }
}
