package org.example;
import java.time.*;

/**
 * Clase que representa un registro de asistencia de los empleados.
 */
public class Asistencia{
    /**
     * Empleado al que se le evalua la asistencia.
     */
    private Empleado empleado;
    /**
     * Hora de llegada del empleado (null si no asistió).
     */
    private Instant horaLLegada;
    /**
     * Indica si el empleado asistió o no.
     */
    private boolean asistio;
    /**
     * Crea un registro de asistencia.
     *
     * @param empleado     Empleado relacionado con la asistencia.
     * @param asistio      Valor que indica si asistió.
     * @param horaLLegada  Hora de llegada del empleado (null si no asistio).
     */
    public Asistencia(Empleado empleado, boolean asistio, Instant horaLLegada){
        this.empleado = empleado;
        this.asistio = asistio;
        this.horaLLegada = horaLLegada;
    }

    /**
     * Devuelve una representación textual del registro de asistencia.
     *
     * @return Cadena con los detalles del registro.
     */
    @Override
    public String toString() {
        return "Asistencia {\n" + "  empleado = " + empleado + "\n" + "  horaLLegada = " + horaLLegada + "\n" + "  asistio = " + asistio + "\n" + "}";
    }
    /**
     * Obtiene el empleado relacionado con esta asistencia.
     *
     * @return Empleado.
     */
    public Empleado getEmpleado() {
        return empleado;
    }
    /**
     * Establece el empleado relacionado con esta asistencia.
     *
     * @param empleado Empleado a asignar.
     */
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }
    /**
     * Obtiene la hora de llegada del empleado.
     *
     * @return Hora de llegada.
     */
    public Instant getHoraLLegada(){
        return horaLLegada;
    }

    /**
     * Establece la hora de llegada del empleado.
     *
     * @param horaLLegada Nueva hora de llegada.
     */
    public void setHoraLLegada(Instant horaLLegada){
        this.horaLLegada = horaLLegada;
    }
    /**
     * Indica si el empleado asistió o no.
     *
     * @return true si asistió, false si no.
     */
    public boolean getAsistio(){
        return asistio;
    }

    /**
     * Establece si el empleado asistió o no.
     *
     * @param asistio true si asistió, false si no.
     */
    public void setAsistio(){
        this.asistio = asistio;
    }
}
