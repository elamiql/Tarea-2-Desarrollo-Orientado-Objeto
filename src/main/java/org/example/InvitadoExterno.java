package org.example;

class InvitadoExterno implements Invitable {
    private String Nombre;
    private String Apellidos;
    private String correoElectronico;

    public InvitadoExterno(String nombres, String apellidos, String correoElectronico) {
        this.Nombre = nombres;
        this.Apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }

    public String getNombres() {
        return Nombre;
    }

    public void setNombres(String nombres) {
        this.Nombre = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public void invitar(Reunion reunion) {
        String mensaje = "Estimado " + Nombre+ " " + Apellidos + ", está invitado a una reunión del tipo ";

        if (reunion instanceof ReunionVirtual) {
            mensaje += "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) {
            mensaje += "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        } else {
            mensaje += reunion.getTipoReunion().name().toLowerCase();
        }

        System.out.println("Invitación enviada a " + Nombre + " vía email: " + correoElectronico + ".\nDetalles: " + mensaje);
    }

    @Override
    public String toString() {
        return Nombre + " " + Apellidos + " (" + correoElectronico + ")";
    }
}

