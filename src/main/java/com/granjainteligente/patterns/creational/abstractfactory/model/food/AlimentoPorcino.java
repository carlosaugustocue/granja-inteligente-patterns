package com.granjainteligente.patterns.creational.abstractfactory.model.food;

/**
 * Representa un alimento para cerdos en la granja.
 * Implementa la interfaz {@link Alimento}.
 * Cada instancia tiene una composición específica.
 */
public class AlimentoPorcino implements Alimento {
    private final String composicion;

    /**
     * Crea un alimento porcino con su composición.
     *
     * @param composicion descripción de los ingredientes o composición del alimento
     */
    public AlimentoPorcino(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Porcino"; }

    @Override
    public String getComposicion() { return composicion; }
}