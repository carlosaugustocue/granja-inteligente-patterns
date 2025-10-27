package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.Gallina;

public class CorralGallinas implements AnimalFactory {

    @Override
    public Animal crear(double peso, int edad) {
        return new Gallina(peso, edad);
    }

}
