package org.example;
import java.time.*;
/**
 * Clase que representa una invitación.
 */
public class Invitacion {
    /**
     * Momento en que se envió la invitación.
     */
    private Instant horaEnvio;
    /**
     * Destinatario de la invitación, que debe implementar la interfaz Invitable.
     */
    private Invitable destinatario;
    /**
     * Reunión a la cual se invita al destinatario.
     */
    private Reunion reunion;
    /**
     * Crea una invitacion.
     *
     * @param destinatario Destinatario de la invitación.
     * @param reunion      Reunión a la que se invita.
     * @param horaEnvio    Hora en que se envió la invitación.
     */
    public Invitacion(Invitable destinatario, Reunion reunion, Instant horaEnvio) {
        this.destinatario = destinatario;
        this.reunion = reunion;
        this.horaEnvio = horaEnvio;
    }
    /**
     * Envía la invitación al destinatario.
     */
    public void enviarInvitacion(){
        destinatario.invitar(reunion);
    }

    /**
     * Devuelve una representación de la invitación.
     *
     * @return Cadena de texto que representa la invitación.
     */
    @Override
    public String toString() {
        return "Invitacion {\n" +
                "  destinatario = " + destinatario + "\n" +
                "  reunion = " + reunion + "\n" +
                "  horaEnvio = " + horaEnvio + "\n" +
                "}";
    }

    /**
     * Obtiene el destinatario de la invitación.
     *
     * @return Destinatario.
     */
    public Invitable getDestinatario(){
        return destinatario;
    }
    /**
     * Establece el destinatario de la invitación.
     *
     * @param destinatario Nuevo destinatario.
     */
    public void setDestinatario(Invitable destinatario){
        this.destinatario = destinatario;
    }
    /**
     * Obtiene la reunión asociada a la invitación.
     *
     * @return Reunión.
     */
    public Reunion getReunion(){
        return reunion;
    }
    /**
     * Establece la reunión asociada a la invitación.
     *
     * @param reunion Nueva reunión.
     */
    public void setReunion(Reunion reunion){
        this.reunion = reunion;
    }
    /**
     * Obtiene la hora en que se envió la invitación.
     *
     * @return Hora de envío.
     */
    public Instant getHoraEnvio(){
        return horaEnvio;
    }
    /**
     * Establece la hora en que se envió la invitación.
     *
     * @param horaEnvio Nueva hora de envío.
     */
    public void setHoraEnvio(Instant horaEnvio){
        this.horaEnvio = horaEnvio;
    }
}
