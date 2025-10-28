package com.granjainteligente.patterns.creational.abstractfactory.model.food;
/**
 * Interfaz base para todos los alimentos de la granja.
 * Define los métodos esenciales que deben implementar todas las clases de alimentos.
 *
 * Métodos:
 * - getTipo(): devuelve el tipo de alimento (ej. Alimento Lechero, Alimento Porcino, Alimento de Aves).
 * - getComposicion(): devuelve la composición o ingredientes del alimento.
 */
public interface Alimento {
    String getTipo();
    String getComposicion();
}