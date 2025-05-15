package org.example;

/**
 * Clase que representa a un invitado externo que puede ser invitado a una reunión.
 */
class InvitadoExterno implements Invitable {
    /**
     * Nombre del invitado externo.
     */
    private String Nombre;
    /**
     * Apellidos del invitado externo.
     */
    private String Apellidos;
    /**
     * Correo electrónico del invitado externo.
     */
    private String correoElectronico;
    /**
     * Crea un invitado externo.
     *
     * @param nombres            Nombre del invitado.
     * @param apellidos          Apellidos del invitado.
     * @param correoElectronico  Correo electrónico del invitado.
     */
    public InvitadoExterno(String nombres, String apellidos, String correoElectronico) {
        this.Nombre = nombres;
        this.Apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }
    /**
     * Obtiene el nombre del invitado.
     *
     * @return Nombre del invitado.
     */
    public String getNombres() {
        return Nombre;
    }
    /**
     * Establece el nombre del invitado.
     *
     * @param nombres Nuevo nombre del invitado.
     */
    public void setNombres(String nombres) {
        this.Nombre = nombres;
    }
    /**
     * Obtiene los apellidos del invitado.
     *
     * @return Apellidos del invitado.
     */
    public String getApellidos() {
        return Apellidos;
    }
    /**
     * Establece los apellidos del invitado.
     *
     * @param apellidos Nuevos apellidos del invitado.
     */
    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }
    /**
     * Obtiene el correo electrónico del invitado.
     *
     * @return Correo electrónico del invitado.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /**
     * Establece el correo electrónico del invitado.
     *
     * @param correoElectronico Nuevo correo electrónico del invitado.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Envía una invitación al invitado para asistir a una reunión.
     *
     * @param reunion Reunión a la que se invita al participante.
     */
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
    /**
     * Devuelve una representación textual del invitado.
     *
     * @return Cadena con el nombre completo y correo del invitado.
     */
    @Override
    public String toString() {
        return Nombre + " " + Apellidos + " (" + correoElectronico + ")";
    }
}

