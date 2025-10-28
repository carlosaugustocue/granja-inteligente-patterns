package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Cerdo;

public class CorralCerdo implements AnimalFactory {

    @Override
    public Animal crear(double peso, int edad) {
        return new Cerdo(peso, edad);
    }

}
