package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;

    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void invitar(Reunion reunion){
        String mensaje = "Estimado " + nombre + " " + apellidos + ", " + "está invitado a una reunion del tipo";

        if (reunion instanceof ReunionVirtual){
            mensaje = mensaje + "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) {
            mensaje = mensaje + "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        }
        System.out.println("Invitacion enviada a " + nombre + "via email: " + correo + "con detalles: " + mensaje);
    }

    //setters
    public String getId(){
        return id;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    //setters
    public void setId(String id){
        this.id = id;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }


}
