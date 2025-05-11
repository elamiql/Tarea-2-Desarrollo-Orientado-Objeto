package org.example;
import java.time.*;

public class Asistencia{
    private Empleado empleado;
    private Instant horaLLegada;
    private boolean asistio;

    public Asistencia(Empleado empleado, boolean asistio, Instant horaLLegada){
        this.empleado = empleado;
        this.asistio = asistio;
        this.horaLLegada = horaLLegada;
    }

    @Override
    public String toString(){
        return "Asistencia{ " + "empleado=" + empleado + ", horaLlegada=" + horaLLegada + ",asistio=" + asistio + "}";
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public Instant getHoraLLegada(){
        return horaLLegada;
    }

    public void setHoraLLegada(Instant horaLLegada){
        this.horaLLegada = horaLLegada;
    }

    public boolean getAsistio(){
        return asistio;
    }

    public void setAsistio(){
        this.asistio = asistio;
    }
}
