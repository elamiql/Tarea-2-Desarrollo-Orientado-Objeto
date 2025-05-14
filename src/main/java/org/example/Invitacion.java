package org.example;
import java.time.*;

public class Invitacion {
    private Instant horaEnvio;
    private Invitable destinatario;
    private Reunion reunion;

    public Invitacion(Invitable destinatario, Reunion reunion, Instant horaEnvio) {
        this.destinatario = destinatario;
        this.reunion = reunion;
        this.horaEnvio = horaEnvio;
    }

    public void enviarInvitacion(){
        destinatario.invitar(reunion);
    }
    @Override
    public String toString(){
        return "Invitacion{" + "destinatario=" + destinatario + ", reunion=" + reunion + ", horaEnvio=" + horaEnvio + '}';
    }

    public Invitable getDestinatario(){
        return destinatario;
    }

    public void setDestinatario(Invitable destinatario){
        this.destinatario = destinatario;
    }

    public Reunion getReunion(){
        return reunion;
    }

    public void setReunion(Reunion reunion){
        this.reunion = reunion;
    }

    public Instant getHoraEnvio(){
        return horaEnvio;
    }

    public void setHoraEnvio(Instant horaEnvio){
        this.horaEnvio = horaEnvio;
    }
}
