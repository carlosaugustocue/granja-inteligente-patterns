package com.granjainteligente.patterns.creational.factorymethod;


import com.granjainteligente.models.Animal;

/**
 * Define la interfaz para la creación de animales.
 * Cada implementación concreta decide cómo instanciar su tipo.
 */

@FunctionalInterface
public interface AnimalFactory {
    Animal crear(double peso, int edad);
}
