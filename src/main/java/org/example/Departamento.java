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
    }

    @Override
    public void invitar(Reunion reunion){
        System.out.println("Enviando invitacion al departamento: "+ nombre);
        for (Empleado empleado : empleados){
            //TODO
        }
    }
}
