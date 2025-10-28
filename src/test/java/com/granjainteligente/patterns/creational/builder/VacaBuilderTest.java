package com.granjainteligente.patterns.creational.builder;

import com.granjainteligente.patterns.creational.builder.builders.VacaBuilder;
import com.granjainteligente.patterns.creational.builder.director.AnimalDirector;
import com.granjainteligente.patterns.creational.builder.model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba unitaria para el {@link VacaBuilder}.
 * Verifica que el objeto construido sea correcto y consistente.
 */
class VacaBuilderTest {

    @Test
    void construirVaca_Correctamente() {
        // Arrange
        AnimalDirector director = new AnimalDirector();
        VacaBuilder builder = new VacaBuilder();

        // Act
        Animal vaca = director.construirAnimal(builder, "Holstein", 4, 350.0, "Alta producción de leche.");

        // Assert
        assertNotNull(vaca);
        assertEquals("Vaca", vaca.getTipo());
        assertEquals("Holstein", vaca.getRaza());
        assertEquals(4, vaca.getEdad());
        assertEquals(350.0, vaca.getPeso());
        assertEquals("Alta producción de leche.", vaca.getDescripcion());
    }
}