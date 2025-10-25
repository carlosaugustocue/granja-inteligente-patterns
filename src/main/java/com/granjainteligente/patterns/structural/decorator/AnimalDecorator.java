package com.granjainteligente.patterns.structural.decorator;

import com.granjainteligente.models.Animal;
import com.granjainteligente.models.EstadoSalud;
import com.granjainteligente.models.TipoAnimal;

/**
 * Clase abstracta base para todos los decoradores de animales.
 * Implementa la interfaz Animal y delega las llamadas al animal decorado.
 *
 * Patrón: Decorator (Structural Pattern)
 * Propósito: Añadir funcionalidades a objetos de forma dinámica sin modificar su clase.
 */
public abstract class AnimalDecorator implements Animal {

    protected Animal animalDecorado;

    public AnimalDecorator(Animal animalDecorado) {
        this.animalDecorado = animalDecorado;
    }

    @Override
    public String getId() {
        return animalDecorado.getId();
    }

    @Override
    public TipoAnimal getTipo() {
        return animalDecorado.getTipo();
    }

    @Override
    public double getPeso() {
        return animalDecorado.getPeso();
    }

    @Override
    public void setPeso(double peso) {
        animalDecorado.setPeso(peso);
    }

    @Override
    public int getEdad() {
        return animalDecorado.getEdad();
    }

    @Override
    public void alimentar(double cantidadAlimento) {
        animalDecorado.alimentar(cantidadAlimento);
    }

    @Override
    public EstadoSalud getEstadoSalud() {
        return animalDecorado.getEstadoSalud();
    }

    @Override
    public void setEstadoSalud(EstadoSalud nuevoEstado) {
        animalDecorado.setEstadoSalud(nuevoEstado);
    }

    @Override
    public String hacerSonido() {
        return animalDecorado.hacerSonido();
    }

    @Override
    public String obtenerInformacion() {
        return animalDecorado.obtenerInformacion();
    }
}
