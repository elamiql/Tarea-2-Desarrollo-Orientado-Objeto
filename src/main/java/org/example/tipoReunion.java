package org.example;

public enum tipoReunion{

    TECNICA(1),
    MARKETING(2),
    OTRO(3);

    private final int tipo;

    tipoReunion(int tipo){
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }
}
