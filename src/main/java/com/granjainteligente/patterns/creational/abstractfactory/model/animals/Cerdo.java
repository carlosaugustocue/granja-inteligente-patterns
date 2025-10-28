package com.granjainteligente.patterns.creational.abstractfactory.model.animals;

/**
 * Representa un cerdo en la granja.
 * Implementa la interfaz {@link Animal}.
 * Cada instancia tiene una raza y descripción específicas.
 */
public class Cerdo implements Animal {
    private final String raza;
    private final String descripcion;

    /**
     * Crea un cerdo con su raza y descripción.
     *
     * @param raza la raza del cerdo
     * @param descripcion descripción breve del cerdo
     */
    public Cerdo(String raza, String descripcion) {
        this.raza = raza;
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Cerdo"; }

    @Override
    public String getRaza() { return raza; }

    @Override
    public String getDescripcion() { return descripcion; }
}