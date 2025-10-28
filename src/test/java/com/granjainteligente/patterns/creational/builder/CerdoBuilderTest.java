package com.granjainteligente.patterns.creational.builder;

import com.granjainteligente.patterns.creational.builder.builders.CerdoBuilder;
import com.granjainteligente.patterns.creational.builder.director.AnimalDirector;
import com.granjainteligente.patterns.creational.builder.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para el {@link CerdoBuilder}.
 * Comprueba que el Builder cree correctamente un cerdo.
 */
class CerdoBuilderTest {

    @Test
    void construirCerdo_Correctamente() {
        // Arrange
        AnimalDirector director = new AnimalDirector();
        CerdoBuilder builder = new CerdoBuilder();

        // Act
        Animal cerdo = director.construirAnimal(builder, "Large White", 2, 180.5, "Raza de excelente carne.");

        // Assert
        assertNotNull(cerdo);
        assertEquals("Cerdo", cerdo.getTipo());
        assertEquals("Large White", cerdo.getRaza());
        assertEquals(2, cerdo.getEdad());
        assertEquals(180.5, cerdo.getPeso());
        assertEquals("Raza de excelente carne.", cerdo.getDescripcion());
    }
}