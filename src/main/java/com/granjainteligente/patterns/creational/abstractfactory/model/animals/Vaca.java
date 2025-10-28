package com.granjainteligente.patterns.creational.abstractfactory.model.animals;

/**
 * Representa una vaca en la granja.
 * Implementa la interfaz {@link Animal}.
 * Cada instancia tiene una raza y descripción específicas.
 */
public class Vaca implements Animal {
    private final String raza;
    private final String descripcion;

    /**
     * Crea una vaca con su raza y descripción.
     *
     * @param raza la raza de la vaca
     * @param descripcion descripción breve de la vaca
     */
    public Vaca(String raza, String descripcion) {
        this.raza = raza;
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Vaca"; }

    @Override
    public String getRaza() { return raza; }

    @Override
    public String getDescripcion() { return descripcion; }
}