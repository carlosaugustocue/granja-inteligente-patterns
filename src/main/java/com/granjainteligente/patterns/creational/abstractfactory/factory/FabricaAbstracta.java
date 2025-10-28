package com.granjainteligente.patterns.creational.abstractfactory.factory;


import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;

/**
 * Interfaz Abstract Factory:
 * define la creación de una familia coherente de objetos relacionados.
 */
public interface FabricaAbstracta {
    Animal crearAnimal();
    Alimento crearAlimento();
    Entorno crearEntorno();
}