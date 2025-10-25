package com.granjainteligente.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementación concreta de una Vaca.
 */
@Getter
@Setter
public class Vaca extends AnimalBase {
    
    private double produccionLecheDiaria;
    private boolean esLechera;
    
    public Vaca(double peso, int edad) {
        super(TipoAnimal.VACA, peso, edad);
        this.esLechera = true;
        this.produccionLecheDiaria = calcularProduccionLeche();
        this.raza = "Holstein"; // Raza por defecto
    }
    
    public Vaca(double peso, int edad, String raza, boolean esLechera) {
        super(TipoAnimal.VACA, peso, edad);
        this.raza = raza;
        this.esLechera = esLechera;
        this.produccionLecheDiaria = esLechera ? calcularProduccionLeche() : 0;
    }
    
    /**
     * Calcula la producción de leche basada en la edad y estado de salud.
     * @return Litros de leche por día
     */
    private double calcularProduccionLeche() {
        if (!esLechera || edad < 24) { // Las vacas empiezan a producir después de 2 años
            return 0;
        }
        
        double produccionBase = 20.0; // 20 litros promedio
        double factorEdad = edad < 84 ? 1.0 : 0.7; // Reducción después de 7 años
        double factorSalud = estadoSalud.getFactorAlimentacion();
        
        return produccionBase * factorEdad * factorSalud;
    }
    
    @Override
    public String hacerSonido() {
        return "¡Muuuu! 🐄";
    }
    
    @Override
    protected double calcularAlimentoBase() {
        // Las vacas lecheras necesitan más alimento
        double alimentoBase = super.calcularAlimentoBase();
        return esLechera ? alimentoBase * 1.3 : alimentoBase;
    }
    
    @Override
    public String obtenerInformacion() {
        String info = super.obtenerInformacion();
        if (esLechera) {
            info += String.format(" [Producción: %.2f L/día]", produccionLecheDiaria);
        }
        return info;
    }
}
