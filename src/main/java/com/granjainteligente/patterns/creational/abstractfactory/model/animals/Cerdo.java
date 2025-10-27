package com.granjainteligente.patterns.creational.abstractfactory.model.animals;

public class Cerdo implements Animal {
    private final String raza;
    private final String descripcion;

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