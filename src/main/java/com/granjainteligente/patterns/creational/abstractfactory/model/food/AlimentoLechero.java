package com.granjainteligente.patterns.creational.abstractfactory.model.food;

public class AlimentoLechero implements Alimento {
    private final String composicion;

    public AlimentoLechero(String composicion) {
        this.composicion = composicion;
    }

    @Override
    public String getTipo() { return "Alimento Lechero"; }

    @Override
    public String getComposicion() { return composicion; }
}