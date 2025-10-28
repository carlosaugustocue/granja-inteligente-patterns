package com.granjainteligente.patterns.creational.abstractfactory.factory;

import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Vaca;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.AlimentoLechero;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.CorralFresco;

/**
 * Fábrica concreta que crea una familia de productos para Vacas Lecheras:
 * Animal: Vaca
 * Alimento: AlimentoLechero
 * Entorno: CorralFresco
 */

public class FabricaVacasLecheras implements FabricaAbstracta {

    @Override
    public Animal crearAnimal() {
        return new Vaca("Holstein", "Vaca lechera de alta producción de leche.");
    }

    @Override
    public Alimento crearAlimento() {
        return new AlimentoLechero("Balanceado rico en calcio y proteínas.");
    }

    @Override
    public Entorno crearEntorno() {
        return new CorralFresco("Corral ventilado y con sombra para vacas lecheras.");
    }
}