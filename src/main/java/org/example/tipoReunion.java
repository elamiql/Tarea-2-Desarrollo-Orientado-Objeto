package org.example;
/**
 * Enum que representa los tipos posibles de reunión.
 */
public enum tipoReunion{
    /**
     * Reunión técnica.
     */
    TECNICA(1),

    /**
     * Reunión de marketing.
     */
    MARKETING(2),
    /**
     * Otro tipo de reunión.
     */
    OTRO(3);
    /**
     * Código numérico asociado al tipo de reunión.
     */
    private final int tipo;
    /**
     * Constructor del enum que asigna un código numérico al tipo.
     *
     * @param tipo Código numérico del tipo de reunión.
     */
    tipoReunion(int tipo){
        this.tipo = tipo;
    }
    /**
     * Obtiene el código numérico asociado al tipo de reunión.
     *
     * @return Código numérico del tipo.
     */
    public int getTipo(){
        return tipo;
    }
}
