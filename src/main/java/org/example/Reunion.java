package org.example;
import java.time.*;
import java.util.*;
import java.util.Date;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;
    private List<Invitable> participantes;
    private List<Nota> notas;

    private Empleado organizador;
    private tipoReunion tipoReunion;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;
        this.asistencias = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }


    public void iniciar(){
        if (this.horaInicio == null){
            this.horaInicio = Instant.now();
            System.out.println("Reunion iniciada a las: " + this.horaInicio);
        }else{
            System.out.println("La reunion ya ha iniciado");
        }
    }

    public void finalizar(){
        this.horaFin = Instant.now();
        System.out.println("Reunion finalizada a las: " + this.horaFin);
    }

    public List<String> obtenerAsistencia(){
        return new ArrayList<>();
    }

    public List<String> obtenerAusencias(){
        return new ArrayList<>();
    }

    public List<Empleado> obtenerRetrasos(){
        List<Empleado> retrasados = new ArrayList<>();

        for (Asistencia asistencia : asistencias){
            if (asistencia instanceof Retraso){
                retrasados.add(asistencia.getEmpleado());
            }
        }
        return retrasados;
    }

    public int obtenerTotalAsistencia(){
        int total = 0;
        return total;
    }

    public float obtenerPorcentajeAsistencia(){
        float total2 = 0;
        return total2;
    }

    public float calcularTiempoReal(){
        float t_total=0;
        return t_total;
    }

    public String getTipo(){
        return "hola";
    }

}