package com.granjainteligente.patterns.creational.factorymethod;


import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Vaca;

/** Fábrica concreta para crear vacas */
public class CorralVacas implements AnimalFactory {

    @Override
    public Animal crear(double peso, int edad) {
        return new Vaca(peso, edad);
    }
}
