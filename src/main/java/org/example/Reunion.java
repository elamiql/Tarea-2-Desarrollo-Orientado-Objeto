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

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion) {
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

    public void iniciar() {
        if (this.horaInicio == null) {
            this.horaInicio = Instant.now();
            System.out.println("Reunion iniciada a las: " + this.horaInicio);
        } else {
            System.out.println("La reunion ya ha iniciado");
        }
    }

    public void finalizar() {
        this.horaFin = Instant.now();
        System.out.println("Reunion finalizada a las: " + this.horaFin);
    }

    public void registrarAsistencia(Empleado empleado, Instant horaDeLlegada) {
        if (this.horaInicio == null) {
            System.out.println("La reunion no comienza aun.");
            return;
        }

        if (!participantes.contains(empleado)) {
            System.out.println("El empleado " + empleado + "no esta invitado.");
            return;
        }

        for (Asistencia asistenciaTrue : asistencias) {
            if (asistenciaTrue.getEmpleado().equals(empleado)) {
                System.out.println("La asistencia de " + empleado + "ya se marco.");
            }
            return;
        }

        boolean asistio;
        Asistencia nuevaAsistencia;
        if (horaDeLlegada.isBefore(horaInicio.plusSeconds(10))) {
            asistio = true;
            nuevaAsistencia = new Asistencia(empleado, asistio, horaDeLlegada);
        } else {
            asistio = false;
            nuevaAsistencia = new Retraso(empleado, horaDeLlegada, this.horaInicio);
        }

        this.asistencias.add(nuevaAsistencia);
    }


    public List<Empleado> obtenerAsistencia() {
        List<Empleado> asistentes = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            if (!(asistencia instanceof Retraso)) {
                asistentes.add(asistencia.getEmpleado());
            }
        }
        return asistentes;
    }

    public List<Empleado> obtenerAusencias() {
        List<Empleado> ausentes = new ArrayList<>();

        for (Invitable participante : participantes) {
            if (participante instanceof Empleado) {
                Empleado empleado = (Empleado) participante;
                boolean sinAsistencia = true;
                for (Asistencia asistencia : asistencias) {
                    if (asistencia.getEmpleado().equals(empleado)) {
                        sinAsistencia = false;
                        break;
                    }
                }
                if (sinAsistencia) {
                    ausentes.add(empleado);
                }
            }
        }
        return ausentes;
    }

    public List<Empleado> obtenerRetrasos() {
        List<Empleado> retrasados = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            if (asistencia instanceof Retraso) {
                retrasados.add(asistencia.getEmpleado());
            }
        }
        return retrasados;
    }

    public float obtenerPorcentajeAsistencia() {
        if (participantes.isEmpty()) {
            return 0.0f;
        } else {
            int totalAsistentes = obtenerTotalAsistencia();
            int numeroParticipantes = participantes.size();
            return (float) totalAsistentes / numeroParticipantes * 100.f;
        }
    }

    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        } else {
            return Duration.ZERO;
        }
    }

    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
            Invitacion invitacion = new Invitacion(participante, this, Instant.now());
            invitaciones.add(invitacion);
            invitacion.enviarInvitacion();
        }
    }

    public int obtenerTotalAsistencia() {
        return asistencias.size();
    }

    public void agregarNota(String nota) {
        Nota n = new Nota(nota);
        this.notas.add(n);
    }

    public void listaNotas() {
        System.out.println("Notas de la reunion:\n");
        for (Nota nota : notas) {
            System.out.println(nota.getContenido());
        }
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "fecha=" + fecha +
                ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", asistencias=" + asistencias +
                ", invitaciones=" + invitaciones +
                ", notas=" + notas +
                ", organizador=" + organizador +
                ", tipoReunion=" + tipoReunion +
                ", participantes=" + participantes +
                '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Invitacion> getInvitaciones(){
        return invitaciones;
    }

    public void setInvitaciones(List<Invitacion> invitaciones){
        this.invitaciones = invitaciones;
    }

    public List<Nota> getNotas(){
        return notas;
    }

    public void setNotas(List<Nota> notas){
        this.notas = notas;
    }

    public Empleado getOrganizador(){
        return organizador;
    }

    public void setOrganizador(Empleado organizador){
        this.organizador = organizador;
    }

    public tipoReunion getTipoReunion(){
        return tipoReunion;
    }

    public void setTipoReunion(tipoReunion tipoReunion){
        this.tipoReunion = tipoReunion;
    }

    public List<Invitable> getParticipantes(){
        return participantes;
    }

    public void setParticipantes(List<Invitable> participantes){
        this.participantes = participantes;
    }
}