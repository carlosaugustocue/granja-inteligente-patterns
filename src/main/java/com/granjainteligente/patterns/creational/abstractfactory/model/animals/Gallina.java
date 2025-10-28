package com.granjainteligente.patterns.creational.abstractfactory.model.animals;

/**
 * Representa una gallina en la granja.
 * Implementa la interfaz {@link Animal}.
 * Cada instancia tiene una raza y descripción específicas.
 */
public class Gallina implements Animal {
    private final String raza;
    private final String descripcion;

    /**
     * Crea una gallina con su raza y descripción.
     *
     * @param raza la raza de la gallina
     * @param descripcion descripción breve de la gallina
     */
    public Gallina(String raza, String descripcion) {
        this.raza = raza;
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Gallina"; }

    @Override
    public String getRaza() { return raza; }

    @Override
    public String getDescripcion() { return descripcion; }
}