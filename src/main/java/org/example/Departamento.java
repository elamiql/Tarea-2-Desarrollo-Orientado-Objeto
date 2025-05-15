package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * CLase que representa a un departamento que contiene empleados.
 */
public class Departamento implements Invitable{
    /**
     * Nombre del departamento.
     */
    private String nombre;
    /**
     * Lista de empleados que pertenecen al departamento.
     */
    private List<Empleado> empleados;
    /**
     * Crea un nuevo departamento con el nombre especificado.
     *
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Obtiene la cantidad de empleados en el departamento.
     *
     * @return Número de empleados.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }
    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado Empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado){
        empleado.setDepartamento(this.nombre);
        empleados.add(empleado);
    }
    /**
     * Invita a todos los empleados del departamento a una reunión,
     *
     * @param reunion Reunión a la que se invita al departamento.
     */
    @Override
    public void invitar(Reunion reunion){
        System.out.println("Enviando invitacion al departamento: "+ nombre);
        for (Empleado empleado : empleados){
            reunion.agregarParticipante(empleado);
        }
    }
    /**
     * Devuelve una representación en cadena del departamento.
     *
     * @return Cadena que representa el objeto Departamento.
     */
    @Override
    public String toString() {
        return "Departamento {\n" +
                "  nombre = " + nombre + "\n" +
                "  empleados = " + empleados + "\n" +
                "}";
    }
    /**
     * Obtiene el nombre del departamento.
     *
     * @return Nombre del departamento.
     */
    public String getNombreDepartamento() {
        return nombre;
    }
    /**
     * Establece el nombre del departamento.
     *
     * @param nombre Nuevo nombre del departamento.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return Lista de empleados.
     */
    public List<Empleado> getEmpleados(){
        return empleados;
    }
    /**
     * Establece la lista de empleados del departamento.
     *
     * @param empleados Nueva lista de empleados.
     */
    public void setEmpleados(List <Empleado> empleados){
        this.empleados = empleados;
    }
}
