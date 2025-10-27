package com.granjainteligente.patterns.creational.abstractfactory.model.food;

public class AlimentoPorcino implements Alimento {
    private final String composicion;

    public AlimentoPorcino(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Porcino"; }

    @Override
    public String getComposicion() { return composicion; }
}