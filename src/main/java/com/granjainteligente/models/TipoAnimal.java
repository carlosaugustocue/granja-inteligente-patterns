package com.granjainteligente.models;

/**
 * Enumeración que define los tipos de animales en la granja.
 */
public enum TipoAnimal {
    VACA("Vaca", "Bovino", 500.0),
    CERDO("Cerdo", "Porcino", 150.0),
    GALLINA("Gallina", "Ave", 2.0);
    
    private final String nombre;
    private final String familia;
    private final double pesoPromedio;
    
    TipoAnimal(String nombre, String familia, double pesoPromedio) {
        this.nombre = nombre;
        this.familia = familia;
        this.pesoPromedio = pesoPromedio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getFamilia() {
        return familia;
    }
    
    public double getPesoPromedio() {
        return pesoPromedio;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
