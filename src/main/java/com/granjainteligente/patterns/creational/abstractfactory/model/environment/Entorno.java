package com.granjainteligente.patterns.creational.abstractfactory.model.environment;
/**
 * Interfaz base para todos los entornos de la granja.
 * Define los métodos esenciales que deben implementar todos los tipos de corrales o gallineros.
 *
 * Métodos:
 * - getTipo(): devuelve el tipo de entorno (ej. Corral Fresco, Corral Cálido, Gallinero).
 * - getDescripcion(): devuelve una descripción del entorno.
 */
public interface Entorno {
    String getTipo();
    String getDescripcion();
}