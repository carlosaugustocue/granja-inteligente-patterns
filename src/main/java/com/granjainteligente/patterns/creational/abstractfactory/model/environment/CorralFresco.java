package com.granjainteligente.patterns.creational.abstractfactory.model.environment;
/**
 * Representa un corral fresco en la granja.
 * Implementa la interfaz {@link Entorno}.
 * Cada instancia tiene una descripción específica del entorno.
 */
public class CorralFresco implements Entorno {
    private final String descripcion;

    /**
     * Crea un corral fresco con su descripción.
     *
     * @param descripcion descripción breve del entorno
     */
    public CorralFresco(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Corral Fresco"; }

    @Override
    public String getDescripcion() { return descripcion; }
}