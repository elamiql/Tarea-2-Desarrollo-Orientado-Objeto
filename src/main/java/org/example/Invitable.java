package org.example;
/**
 * Interfaz que representa la capacidad de ser invitado a una reunión.
 */
public interface Invitable {

    /**
     * Envía una invitación a la reunión especificada.
     *
     * @param reunion Reunión a la que se invita.
     */
    void invitar(Reunion reunion);
}
