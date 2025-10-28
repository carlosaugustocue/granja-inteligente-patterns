package com.granjainteligente.patterns.creational.abstractfactory.model.environment;
/**
 * Representa un corral cálido en la granja.
 * Implementa la interfaz {@link Entorno}.
 * Cada instancia tiene una descripción específica del entorno.
 */
public class CorralCalido implements Entorno {
    private final String descripcion;

    /**
     * Crea un corral cálido con su descripción.
     *
     * @param descripcion descripción breve del entorno
     */
    public CorralCalido(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Corral Cálido"; }

    @Override
    public String getDescripcion() { return descripcion; }
}
