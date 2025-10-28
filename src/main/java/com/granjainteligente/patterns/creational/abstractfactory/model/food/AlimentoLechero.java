package com.granjainteligente.patterns.creational.abstractfactory.model.food;

/**
 * Representa un alimento para vacas lecheras en la granja.
 * Implementa la interfaz {@link Alimento}.
 * Cada instancia tiene una composición específica.
 */
public class AlimentoLechero implements Alimento {
    private final String composicion;

    /**
     * Crea un alimento lechero con su composición.
     *
     * @param composicion descripción de los ingredientes o composición del alimento
     */
    public AlimentoLechero(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Lechero"; }

    @Override
    public String getComposicion() { return composicion; }
}