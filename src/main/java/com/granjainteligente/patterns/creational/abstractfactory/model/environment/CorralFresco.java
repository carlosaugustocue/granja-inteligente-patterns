package com.granjainteligente.patterns.creational.abstractfactory.model.environment;

public class CorralFresco implements Entorno {
    private final String descripcion;

    public CorralFresco(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getTipo() { return "Corral Fresco"; }

    @Override
    public String getDescripcion() { return descripcion; }
}