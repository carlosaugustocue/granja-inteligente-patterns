package com.granjainteligente.patterns.creational.abstractfactory.model.food;

public class AlimentoAves implements Alimento {
    private final String composicion;

    public AlimentoAves(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Aves"; }

    @Override
    public String getComposicion() { return composicion; }
}