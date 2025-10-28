package com.granjainteligente.patterns.creational.builder;

import com.granjainteligente.patterns.creational.builder.builders.GallinaBuilder;
import com.granjainteligente.patterns.creational.builder.director.AnimalDirector;
import com.granjainteligente.patterns.creational.builder.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para el {@link GallinaBuilder}.
 * Asegura que construya correctamente una gallina.
 */
class GallinaBuilderTest {

    @Test
    void construirGallina_Correctamente() {
        // Arrange
        AnimalDirector director = new AnimalDirector();
        GallinaBuilder builder = new GallinaBuilder();

        // Act
        Animal gallina = director.construirAnimal(builder, "Leghorn", 1, 2.1, "Ponedora eficiente.");

        // Assert
        assertNotNull(gallina);
        assertEquals("Gallina", gallina.getTipo());
        assertEquals("Leghorn", gallina.getRaza());
        assertEquals(1, gallina.getEdad());
        assertEquals(2.1, gallina.getPeso());
        assertEquals("Ponedora eficiente.", gallina.getDescripcion());
    }
}