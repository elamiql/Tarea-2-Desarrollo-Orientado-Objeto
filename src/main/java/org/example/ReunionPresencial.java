package org.example;
import java.time.*;
import java.util.*;


public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String sala){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }

    public String getSala(){
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }
}
