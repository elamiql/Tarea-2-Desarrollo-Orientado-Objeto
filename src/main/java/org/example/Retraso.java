package org.example;
import java.time.*;

public class Retraso extends Asistencia{
    private Duration duracionRetraso;

    public Retraso(Empleado empleado, Instant horadeLLegada, Instant horaInicio) {
        super(empleado, true, horaInicio);
        this.duracionRetraso = Duration.between(horaInicio, horadeLLegada);
    }

    @Override
    public String toString(){
        return "Retraso{" + "duracionRetraso=" + duracionRetraso + "}";
    }

    public Duration getDuracionRetraso(){
        return duracionRetraso;
    }

    public void setDuracionRetraso(Duration duracionRetraso){
        this.duracionRetraso = duracionRetraso;
    }
}
