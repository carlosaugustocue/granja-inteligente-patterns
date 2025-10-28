package com.granjainteligente.patterns.creational.abstractfactory;

import com.granjainteligente.patterns.creational.abstractfactory.factory.FabricaCerdos;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para la fábrica concreta de cerdos.
 * Comprueba que los objetos creados pertenecen a la misma familia.
 */
class FabricaCerdosTest {

    @Test
    void crearFamiliaDeCerdos_Correctamente() {
        // Arrange
        FabricaCerdos fabrica = new FabricaCerdos();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert - Verificar que no sean null
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);

        // Assert - Verificar tipos exactos
        assertEquals("Cerdo", animal.getTipo());
        assertEquals("Alimento Porcino", alimento.getTipo());
        assertEquals("Corral Cálido", entorno.getTipo());
    }
}