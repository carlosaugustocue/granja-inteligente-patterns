package com.granjainteligente.patterns.creational.abstractfactory.model.environment;

/**
 * Representa un gallinero en la granja.
 * Implementa la interfaz {@link Entorno}.
 * Cada instancia tiene una descripción específica del entorno.
 */
public class Gallinero implements Entorno {
    private final String descripcion;

    /**
     * Crea un gallinero con su descripción.
     *
     * @param descripcion descripción breve del entorno
     */
    public Gallinero(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Gallinero"; }

    @Override
    public String getDescripcion() { return descripcion; }
}