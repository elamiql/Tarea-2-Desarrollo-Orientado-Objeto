package org.example;
/**
 * Clase que representa una nota con un contenido de texto.
 */
public class Nota {
    /**
     * Contenido textual de la nota.
     */
    private String contenido;
    /**
     * Crea una nota con texto.
     *
     * @param contenido Texto de la nota.
     */
    public Nota (String contenido){
        this.contenido = contenido;
    }

    /**
     * Obtiene el contenido de la nota.
     *
     * @return Texto contenido en la nota.
     */
    public String getContenido(){
        return contenido;
    }
    /**
     * Devuelve una representación en cadena de texto de la nota.
     *
     * @return El contenido de la nota.
     */
    @Override
    public String toString() {
        return "Nota: " + contenido;
    }
}
