package com.granjainteligente.patterns.creational.builder;

import com.granjainteligente.patterns.creational.builder.builders.*;
import com.granjainteligente.patterns.creational.builder.director.AnimalDirector;
import com.granjainteligente.patterns.creational.builder.interfaces.AnimalBuilder;
import com.granjainteligente.patterns.creational.builder.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba de integración para el patrón Builder.
 * Verifica que diferentes Builders produzcan animales válidos y consistentes.
 */
class BuilderIntegrationTest {

    @Test
    void todosLosBuilders_DebenConstruirAnimalesCoherentes() {
        // Arrange
        AnimalDirector director = new AnimalDirector();
        var builders = new AnimalBuilder[] {
                new VacaBuilder(),
                new CerdoBuilder(),
                new GallinaBuilder()
        };

        // Act & Assert
        for (var builder : builders) {
            Animal animal = director.construirAnimal(builder, "TestRaza", 1, 10.0, "Animal de prueba.");
            assertNotNull(animal);
            assertNotNull(animal.getTipo());
            assertTrue(animal.getPeso() > 0);
            assertTrue(animal.getEdad() >= 0);
        }
    }
}