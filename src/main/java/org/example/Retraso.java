package org.example;
import java.time.*;

public class Retraso extends Asistencia{
    private Instant hora;

    public Retraso(Empleado empleado, boolean asistio, Instant horaLLegada) {
        super(empleado, asistio, horaLLegada);
    }
}
