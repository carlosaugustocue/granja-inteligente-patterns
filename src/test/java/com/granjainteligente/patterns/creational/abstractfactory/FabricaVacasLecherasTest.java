package com.granjainteligente.patterns.creational.abstractfactory;

import com.granjainteligente.patterns.creational.abstractfactory.factory.FabricaVacasLecheras;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para la fábrica concreta de vacas lecheras.
 * Verifica que cree una familia coherente de objetos relacionados.
 */
class FabricaVacasLecherasTest {

    @Test
    void crearFamiliaDeVacasLecheras_Correctamente() {
        // Arrange
        FabricaVacasLecheras fabrica = new FabricaVacasLecheras();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert - Verificar que no sean null
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);

        // Assert - Verificar tipos exactos
        assertEquals("Vaca", animal.getTipo());
        assertEquals("Alimento Lechero", alimento.getTipo());
        assertEquals("Corral Fresco", entorno.getTipo());
    }
}