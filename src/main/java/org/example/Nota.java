package org.example;

import java.time.Instant;

/**
 * Clase que representa una nota con un contenido de texto.
 */
public class Nota {
    /**
     * Contenido textual de la nota.
     */
    private String contenido;
    /** Momento en el que se creó la nota. */
    private Instant time;
    /**
     * Crea una nota con texto.
     *
     * @param contenido Texto de la nota.
     */


    public Nota (String contenido){

        this.contenido = contenido;
        this.time= Instant.now();
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
     * Establece el contenido de la nota.
     *
     * @param contenido El nuevo contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Obtiene el instante en que se creó la nota.
     *
     * @return Marca de tiempo de creación.
     */
    public Instant getTime() {
        return time;
    }

    /**
     * Establece el instante de la nota.
     * Normalmente no deberia usarse.
     *
     * @param time Nueva marca de tiempo.
     */
    public void setTime(Instant time) {
        this.time = time;
    }
    /**
     * Devuelve una representación en cadena de texto de la nota.
     *
     * @return El contenido de la nota.
     */
    @Override
    public String toString() {
        return "Nota{contenido='" + contenido + "'}";
    }
}
