package com.granjainteligente.patterns.creational.builder.builders;

import com.granjainteligente.patterns.creational.builder.interfaces.AnimalBuilder;
import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Builder concreto para construir {@link Animal} del tipo "Gallina".
 * El tipo se establece internamente al construir el objeto.
 */
public class GallinaBuilder implements AnimalBuilder {

    private String raza;
    private int edad;
    private double peso;
    private String descripcion;

    @Override
    public AnimalBuilder setRaza(String raza) {
        this.raza = raza;
        return this;
    }

    @Override
    public AnimalBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    @Override
    public AnimalBuilder setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    @Override
    public AnimalBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    @Override
    public Animal build() {
        return new Animal("Gallina", raza, edad, peso, descripcion);
    }
}