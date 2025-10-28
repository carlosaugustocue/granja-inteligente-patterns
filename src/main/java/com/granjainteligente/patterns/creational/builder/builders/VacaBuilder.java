package com.granjainteligente.patterns.creational.builder.builders;

import com.granjainteligente.patterns.creational.builder.interfaces.AnimalBuilder;
import com.granjainteligente.patterns.creational.builder.model.Animal;

/**
 * Builder concreto para construir objetos {@link Animal} del tipo "Vaca".
 * Los valores son configurables externamente (no se queman datos).
 */
public class VacaBuilder implements AnimalBuilder {

    private String tipo;
    private String raza;
    private int edad;
    private double peso;
    private String descripcion;

    @Override
    public AnimalBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

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
        return new Animal(tipo, raza, edad, peso, descripcion);
    }
}