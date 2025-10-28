package com.granjainteligente.patterns.creational.abstractfactory.factory;

import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Gallina;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.AlimentoAves;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Gallinero;

/**
 * Fábrica concreta que crea una familia de productos para Gallinas:
 * Animal: Gallina
 * Alimento: AlimentoAves
 * Entorno: Gallinero
 */

public class FabricaGallinas implements FabricaAbstracta {

    @Override
    public Animal crearAnimal() {
        return new Gallina("Leghorn", "Gallina ponedora de raza Leghorn.");
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoAves("Alimento balanceado alto en calcio.");
    }

    @Override
    public Entorno crearEntorno() {
        return new Gallinero("Gallinero espacioso con perchas y nidos.");
    }
}