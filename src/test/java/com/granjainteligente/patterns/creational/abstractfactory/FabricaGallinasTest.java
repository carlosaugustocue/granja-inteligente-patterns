package com.granjainteligente.patterns.creational.abstractfactory;

import com.granjainteligente.patterns.creational.abstractfactory.factory.FabricaGallinas;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para la fábrica concreta de gallinas.
 * Verifica que la familia de objetos creados sea coherente.
 */
class FabricaGallinasTest {

    @Test
    void crearFamiliaDeGallinas_Correctamente() {
        // Arrange
        FabricaGallinas fabrica = new FabricaGallinas();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert - Verificar que no sean null
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);

        // Assert - Verificar tipos exactos
        assertEquals("Gallina", animal.getTipo());
        assertEquals("Alimento Aves", alimento.getTipo());
        assertEquals("Gallinero", entorno.getTipo());
    }
}