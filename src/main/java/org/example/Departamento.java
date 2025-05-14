package org.example;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    //TODO
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void agregarEmpleado(Empleado empleado){
        empleado.setDepartamento(this.nombre);
        empleados.add(empleado);
    }

    @Override
    public void invitar(Reunion reunion){
        System.out.println("Enviando invitacion al departamento: "+ nombre);
        for (Empleado empleado : empleados){
            reunion.agregarParticipante(empleado);
        }
    }

    @Override
    public String toString(){
        return "Departamento{" + "nombre=" + nombre + '\'' + ", empleados=" + empleados + "}";
    }

    public String getNombreDepartamento() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }

    public void setEmpleados(List <Empleado> empleados){
        this.empleados = empleados;
    }
}
