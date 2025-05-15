package org.example;
import java.time.*;
import java.util.*;
import java.util.Date;
/**
 * Clase que representa una reunion puede ser virtual o fisica.
 */
public abstract class Reunion {
    /** Fecha de la reunión */
    private Date fecha;
    /** Hora prevista para el inicio de la reunión */
    private Instant horaPrevista;
    /** Duración prevista de la reunión */
    private Duration duracionPrevista;
    /** Hora real de inicio */
    private Instant horaInicio;
    /** Hora real de finalización */
    private Instant horaFin;

    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;
    private List<Invitable> participantes;
    private List<Nota> notas;
    /** Empleado organizador de la reunión */
    private Empleado organizador;
    /** Tipo de la reunión */
    private tipoReunion tipoReunion;
    /**
     * Crea una reunion.
     *
     * @param fecha Fecha de la reunión
     * @param horaPrevista Hora prevista de inicio
     * @param duracionPrevista Duración prevista
     * @param organizador Empleado que organiza la reunión
     * @param tipoReunion Tipo de la reunión (técnica, marketing, otro)
     */
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
    /**
     * Inicia la reunión marcando la hora actual como inicio.
     */
    public void iniciar() {
        if (this.horaInicio == null) {
            this.horaInicio = Instant.now();
            System.out.println("Reunion iniciada a las: " + this.horaInicio);
        } else {
            System.out.println("La reunion ya ha iniciado");
        }
    }
    /**
     * Finaliza la reunión marcando la hora actual como fin.
     */
    public void finalizar() {
        this.horaFin = Instant.now();
        System.out.println("Reunion finalizada a las: " + this.horaFin);
    }
    /**
     * Registra la asistencia de un empleado según su hora de llegada.
     * Si llega tarde, se registra como retraso.
     *
     * @param empleado Empleado que asiste.
     * @param horaDeLlegada Hora de llegada.
     */
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


    /**
     * Obtiene la lista de empleados que asistieron puntualmente.
     *
     * @return Lista de empleados puntuales.
     */
    public List<Empleado> obtenerAsistencia() {
        List<Empleado> asistentes = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            if (!(asistencia instanceof Retraso)) {
                asistentes.add(asistencia.getEmpleado());
            }
        }
        return asistentes;
    }
    /**
     * Obtiene la lista de empleados que no asistieron.
     *
     * @return Lista de empleados ausentes.
     */
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
    /**
     * Obtiene la lista de empleados que llegaron con retraso.
     *
     * @return Lista de empleados con retraso
     */
    public List<Empleado> obtenerRetrasos() {
        List<Empleado> retrasados = new ArrayList<>();

        for (Asistencia asistencia : asistencias) {
            if (asistencia instanceof Retraso) {
                retrasados.add(asistencia.getEmpleado());
            }
        }
        return retrasados;
    }
    /**
     * Calcula el porcentaje de asistencia respecto al total de participantes.
     *
     * @return Porcentaje de asistencia
     */
    public float obtenerPorcentajeAsistencia() {
        if (participantes.isEmpty()) {
            return 0.0f;
        } else {
            int totalAsistentes = obtenerTotalAsistencia();
            int numeroParticipantes = participantes.size();
            return (float) totalAsistentes / numeroParticipantes * 100.f;
        }
    }
    /**
     * Calcula la duración de la reunion si esta ya finalizo.
     *
     * @return Duración real como {@code Duration}
     */
    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        } else {
            return Duration.ZERO;
        }
    }
    /**
     * Agrega un participante a la reunión y le envía una invitación.
     *
     * @param participante Participante a invitar
     */
    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
            Invitacion invitacion = new Invitacion(participante, this, Instant.now());
            invitaciones.add(invitacion);
            invitacion.enviarInvitacion();
        }
    }
    /**
     * Devuelve el total de registros de asistencia.
     *
     * @return Número total de asistencias registradas.
     */
    public int obtenerTotalAsistencia() {
        return asistencias.size();
    }
    /**
     * Agrega una nota escrita a la reunión.
     *
     * @param nota Texto de la nota
     */
    public void agregarNota(String nota) {
        Nota n = new Nota(nota);
        this.notas.add(n);
    }
    /**
     * Muestra las notas asociadas a la reunión.
     */

    public void listaNotas() {
        System.out.println("Notas de la reunion:\n");
        for (Nota nota : notas) {
            System.out.println(nota.getContenido());
        }
    }

    /**
     * Obtiene la fecha de la reunión.
     * @return Fecha de la reunión.
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha de la reunión.
     * @param fecha Nueva fecha de la reunión.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene la hora prevista de la reunión.
     * @return Hora prevista de inicio.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    /**
     * Establece la hora prevista de la reunión.
     * @param horaPrevista Nueva hora prevista.
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * Obtiene la duración prevista de la reunión.
     * @return Duración prevista.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Establece la duración prevista de la reunión.
     * @param duracionPrevista Nueva duración prevista.
     */
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Obtiene la hora real de inicio de la reunión.
     * @return Hora de inicio.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }
    /**
     * Establece la hora real de inicio.
     * @param horaInicio Nueva hora de inicio.
     */
    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }
    /**
     * Obtiene la hora de finalización de la reunión.
     * @return Hora de fin.
     */
    public Instant getHoraFin() {
        return horaFin;
    }
    /**
     * Establece la hora de finalización de la reunión.
     * @param horaFin Nueva hora de fin.
     */
    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }
    /**
     * Obtiene la lista de asistencias registradas.
     * @return Lista de asistencias.
     */
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    /**
     * Establece la lista de asistencias.
     * @param asistencias Nueva lista de asistencias.
     */
    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    /**
     * Obtiene la lista de invitaciones enviadas.
     * @return Lista de invitaciones.
     */
    public List<Invitacion> getInvitaciones(){
        return invitaciones;
    }
    /**
     * Establece la lista de invitaciones.
     * @param invitaciones Nueva lista de invitaciones.
     */
    public void setInvitaciones(List<Invitacion> invitaciones){
        this.invitaciones = invitaciones;
    }

    /**
     * Obtiene la lista de notas de la reunión.
     * @return Lista de notas.
     */
    public List<Nota> getNotas(){
        return notas;
    }

    /**
     * Establece la lista de notas.
     * @param notas Nueva lista de notas.
     */
    public void setNotas(List<Nota> notas){
        this.notas = notas;
    }
    /**
     * Obtiene el organizador de la reunión.
     * @return Empleado organizador.
     */
    public Empleado getOrganizador(){
        return organizador;
    }
    /**
     * Establece el organizador de la reunión.
     * @param organizador Nuevo organizador.
     */
    public void setOrganizador(Empleado organizador){
        this.organizador = organizador;
    }
    /**
     * Obtiene el tipo de la reunión.
     * @return Tipo de reunión.
     */
    public tipoReunion getTipoReunion(){
        return tipoReunion;
    }

    /**
     * Establece el tipo de la reunión.
     * @param tipoReunion Nuevo tipo.
     */
    public void setTipoReunion(tipoReunion tipoReunion){
        this.tipoReunion = tipoReunion;
    }

    /**
     * Obtiene la lista de participantes invitados.
     * @return Lista de participantes.
     */
    public List<Invitable> getParticipantes(){
        return participantes;
    }

    /**
     * Establece la lista de participantes.
     * @param participantes Nueva lista de participantes.
     */
    public void setParticipantes(List<Invitable> participantes){
        this.participantes = participantes;
    }
}