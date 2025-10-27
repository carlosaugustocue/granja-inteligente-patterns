package com.granjainteligente.patterns.creational.abstractfactory.model.environment;

public class CorralCalido implements Entorno {
    private final String descripcion;

    public CorralCalido(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Corral Cálido"; }

    @Override
    public String getDescripcion() { return descripcion; }
}
