package com.granjainteligente.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para los modelos de animales.
 */
class AnimalTest {
    
    private Vaca vaca;
    private Cerdo cerdo;
    private Gallina gallina;
    
    @BeforeEach
    void setUp() {
        vaca = new Vaca(500, 36); // 500kg, 3 años
        cerdo = new Cerdo(150, 8); // 150kg, 8 meses
        gallina = new Gallina(2, 12); // 2kg, 1 año
    }
    
    @Test
    @DisplayName("Test creación de Vaca")
    void testCrearVaca() {
        assertNotNull(vaca);
        assertEquals(TipoAnimal.VACA, vaca.getTipo());
        assertEquals(500, vaca.getPeso());
        assertEquals(36, vaca.getEdad());
        assertEquals(EstadoSalud.SANO, vaca.getEstadoSalud());
        assertTrue(vaca.isEsLechera());
    }
    
    @Test
    @DisplayName("Test creación de Cerdo")
    void testCrearCerdo() {
        assertNotNull(cerdo);
        assertEquals(TipoAnimal.CERDO, cerdo.getTipo());
        assertEquals(150, cerdo.getPeso());
        assertEquals(8, cerdo.getEdad());
        assertEquals(EstadoSalud.SANO, cerdo.getEstadoSalud());
    }
    
    @Test
    @DisplayName("Test creación de Gallina")
    void testCrearGallina() {
        assertNotNull(gallina);
        assertEquals(TipoAnimal.GALLINA, gallina.getTipo());
        assertEquals(2, gallina.getPeso());
        assertEquals(12, gallina.getEdad());
        assertEquals(EstadoSalud.SANO, gallina.getEstadoSalud());
        assertTrue(gallina.isEsPonedora());
    }
    
    @Test
    @DisplayName("Test alimentar animal")
    void testAlimentarAnimal() {
        double pesoInicial = vaca.getPeso();
        vaca.alimentar(10.0); // 10 kg de alimento
        assertTrue(vaca.getPeso() > pesoInicial);
    }
    
    @Test
    @DisplayName("Test cambio de estado de salud")
    void testCambioEstadoSalud() {
        vaca.setEstadoSalud(EstadoSalud.ENFERMO);
        assertEquals(EstadoSalud.ENFERMO, vaca.getEstadoSalud());
    }
    
    @Test
    @DisplayName("Test sonidos de animales")
    void testSonidosAnimales() {
        assertEquals("¡Muuuu! 🐄", vaca.hacerSonido());
        assertEquals("¡Oink oink! 🐷", cerdo.hacerSonido());
        assertEquals("¡Coc coc coc! 🐔", gallina.hacerSonido());
    }
    
    @Test
    @DisplayName("Test producción de leche")
    void testProduccionLeche() {
        Vaca vacaJoven = new Vaca(400, 18); // Menor de 2 años
        Vaca vacaAdulta = new Vaca(500, 36); // 3 años
        
        assertEquals(0, vacaJoven.getProduccionLecheDiaria());
        assertTrue(vacaAdulta.getProduccionLecheDiaria() > 0);
    }
    
    @Test
    @DisplayName("Test producción de huevos")
    void testProduccionHuevos() {
        Gallina gallinaJoven = new Gallina(1.5, 3); // 3 meses
        Gallina gallinaAdulta = new Gallina(2, 12); // 1 año
        
        assertEquals(0, gallinaJoven.getHuevosPorSemana());
        assertTrue(gallinaAdulta.getHuevosPorSemana() > 0);
    }
    
    @Test
    @DisplayName("Test información del animal")
    void testInformacionAnimal() {
        String info = vaca.obtenerInformacion();
        assertNotNull(info);
        assertTrue(info.contains("VACA"));
        assertTrue(info.contains(vaca.getId()));
    }
}
