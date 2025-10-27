package com.granjainteligente.patterns.creational.abstractfactory.model.environment;

public class Gallinero implements Entorno {
    private final String descripcion;

    public Gallinero(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Gallinero"; }

    @Override
    public String getDescripcion() { return descripcion; }
}