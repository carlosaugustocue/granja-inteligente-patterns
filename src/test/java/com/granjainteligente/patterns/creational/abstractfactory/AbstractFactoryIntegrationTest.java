package com.granjainteligente.patterns.creational.abstractfactory;

import com.granjainteligente.patterns.creational.abstractfactory.factory.*;
import com.granjainteligente.patterns.creational.abstractfactory.model.animals.Animal;
import com.granjainteligente.patterns.creational.abstractfactory.model.environment.Entorno;
import com.granjainteligente.patterns.creational.abstractfactory.model.food.Alimento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba de integración para el patrón Abstract Factory.
 * Valida que todas las fábricas concretas generen familias coherentes.
 */
class AbstractFactoryIntegrationTest {

    @Test
    void fabricaVacas_DeberiaCrearFamiliaCoherente() {
        // Arrange
        FabricaAbstracta fabrica = new FabricaVacasLecheras();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);
        assertEquals("Vaca", animal.getTipo());
        assertEquals("Alimento Lechero", alimento.getTipo());
        assertEquals("Corral Fresco", entorno.getTipo());
    }

    @Test
    void fabricaCerdos_DeberiaCrearFamiliaCoherente() {
        // Arrange
        FabricaAbstracta fabrica = new FabricaCerdos();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);
        assertEquals("Cerdo", animal.getTipo());
        assertEquals("Alimento Porcino", alimento.getTipo());
        assertEquals("Corral Cálido", entorno.getTipo());
    }

    @Test
    void fabricaGallinas_DeberiaCrearFamiliaCoherente() {
        // Arrange
        FabricaAbstracta fabrica = new FabricaGallinas();

        // Act
        Animal animal = fabrica.crearAnimal();
        Alimento alimento = fabrica.crearAlimento();
        Entorno entorno = fabrica.crearEntorno();

        // Assert
        assertNotNull(animal);
        assertNotNull(alimento);
        assertNotNull(entorno);
        assertEquals("Gallina", animal.getTipo());
        assertEquals("Alimento Aves", alimento.getTipo());
        assertEquals("Gallinero", entorno.getTipo());
    }

    @Test
    void todasLasFabricas_DeberianCrearObjetosNoNulos() {
        // Arrange
        FabricaAbstracta[] fabricas = {
                new FabricaVacasLecheras(),
                new FabricaCerdos(),
                new FabricaGallinas()
        };

        // Act & Assert
        for (FabricaAbstracta fabrica : fabricas) {
            assertNotNull(fabrica.crearAnimal());
            assertNotNull(fabrica.crearAlimento());
            assertNotNull(fabrica.crearEntorno());
        }
    }
}