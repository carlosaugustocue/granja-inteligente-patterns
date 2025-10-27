package com.granjainteligente.patterns.creational.abstractfactory.model.food;

/**
 * Representa un alimento para aves en la granja.
 * Implementa la interfaz {@link Alimento}.
 * Cada instancia tiene una composición específica.
 */
public class AlimentoAves implements Alimento {
    private final String composicion;

    /**
     * Crea un alimento para aves con su composición.
     *
     * @param composicion descripción de los ingredientes o composición del alimento
     */
    public AlimentoAves(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Aves"; }

    @Override
    public String getComposicion() { return composicion; }
}