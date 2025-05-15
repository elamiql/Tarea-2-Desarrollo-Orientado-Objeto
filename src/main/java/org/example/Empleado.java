package org.example;

/**
 * Clase que representa a empleado
 */
public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;

    /**
     * Crea un nuevo empleado.
     *
     * @param id        Identificador del empleado.
     * @param apellidos Apellidos del empleado.
     * @param nombre    Nombre del empleado.
     * @param correo    Correo electrónico del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Envía una invitación al empleado para una reunión.
     *
     * @param reunion Reunion a la cual esta invitado el empleado.
     */
    @Override
    public void invitar(Reunion reunion) {
        String mensaje = "Estimado " + nombre + " " + apellidos + ", está invitado a una reunión del tipo ";

        if (reunion instanceof ReunionVirtual) {
            mensaje += "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) {
            mensaje += "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        }

        System.out.println("Invitación enviada a " + nombre + " vía email: " + correo + " con detalles: " + mensaje);
    }

    /**
     * Obtiene el ID del empleado.
     *
     * @return ID del empleado.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     *
     * @param id Nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return Apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return Correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo Nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Establece el departamento del empleado.
     *
     * @param departamento Nombre del departamento.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    /**
     * Obtiene el departamento del empleado.
     *
     * @return Departamento.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     *  Representacion escrita del empleado.
     *
     * @return Cadena con los datos del empleado.
     */
    @Override
    public String toString() {
        return "Empleado {\n" +
                "  id = " + id + "\n" + "  apellidos = " + apellidos + "\n" + "  nombre = " + nombre + "\n" + "  correo = " + correo + "\n" + "  departamento = " + departamento + "\n" + "}";
    }

}

