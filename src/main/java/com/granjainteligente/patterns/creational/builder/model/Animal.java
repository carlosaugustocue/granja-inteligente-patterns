package com.granjainteligente.patterns.creational.builder.model;

/**
 * Producto final construido por los Builders.
 */
public class Animal {
    private final String tipo;
    private final String raza;
    private final int edad;
    private final double peso;
    private final String descripcion;

    public Animal(String tipo, String raza, int edad, double peso, String descripcion) {
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.descripcion = descripcion;
    }

    public String getTipo() { return tipo; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }
    public double getPeso() { return peso; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return String.format("%s (%s) - Edad: %d años, Peso: %.2f kg. %s",
                tipo, raza, edad, peso, descripcion);
    }
}