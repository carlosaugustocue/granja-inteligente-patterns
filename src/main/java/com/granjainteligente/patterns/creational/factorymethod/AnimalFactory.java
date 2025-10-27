package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;
import lombok.extern.slf4j.Slf4j;


/**
 * Factory Method - Clase abstracta que define la interfaz para crear animales.
 * <p>
 * Las subclases decidirán qué animal específico instanciar según el propósito
 * del corral. Esta clase también gestiona lógica común como el conteo
 * y registro de animales creados.
 */

@Slf4j
public abstract class AnimalFactory {

    /**
     * Contador protegido para que las subclases puedan accederlo si es necesario,
     * pero no es público.
     */
    protected int contadorAnimales = 0;

    /**
     * Método abstracto que las subclases deben implementar para crear el tipo
     * específico de animal para su corral.
     * * @param raza La raza o tipo genético del animal.
     * @return una nueva instancia de Animal.
     */

    public abstract Animal crearAnimal(String raza);

    /**
     * Método "template" que usa el factory method para crear y luego
     * procesar/registrar el animal.
     *
     * @param raza La raza del animal a registrar.
     * @return El animal creado y procesado.
     */

    public Animal registrarNuevoAnimal(String raza) {
        // 1. Llama al factory method (implementado por la subclase)
        Animal animal = crearAnimal(raza);

        // 2. Lógica común después de la creación
        // Lombok provee la variable "log" automáticamente
        log.info("Procesando nuevo animal para el corral: {}", animal.getClass().getSimpleName());

        contadorAnimales++;

        return animal;
    }

    /**
     * Obtiene el número total de animales creados por esta fábrica.
     *
     * @return el contador de animales.
     */
    public int getContadorAnimales() {
        return contadorAnimales;
    }
}
