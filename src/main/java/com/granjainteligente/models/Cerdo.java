package com.granjainteligente.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementación concreta de un Cerdo.
 */
@Getter
@Setter
public class Cerdo extends AnimalBase {
    
    private boolean esReproductor;
    private double tasaCrecimiento;
    
    public Cerdo(double peso, int edad) {
        super(TipoAnimal.CERDO, peso, edad);
        this.esReproductor = false;
        this.tasaCrecimiento = 1.5; // kg por mes
        this.raza = "Yorkshire"; // Raza por defecto
    }
    
    public Cerdo(double peso, int edad, String raza, boolean esReproductor) {
        super(TipoAnimal.CERDO, peso, edad);
        this.raza = raza;
        this.esReproductor = esReproductor;
        this.tasaCrecimiento = calcularTasaCrecimiento();
    }
    
    /**
     * Calcula la tasa de crecimiento basada en la edad y genética.
     * @return Tasa de crecimiento en kg/mes
     */
    private double calcularTasaCrecimiento() {
        double tasaBase = 1.5;
        
        // Los cerdos jóvenes crecen más rápido
        if (edad < 6) {
            tasaBase *= 1.5;
        } else if (edad > 12) {
            tasaBase *= 0.5;
        }
        
        // Factor de salud
        tasaBase *= estadoSalud.getFactorAlimentacion();
        
        return tasaBase;
    }
    
    @Override
    public String hacerSonido() {
        return "¡Oink oink! 🐷";
    }
    
    @Override
    protected double calcularAlimentoBase() {
        // Los cerdos en crecimiento necesitan más alimento
        double alimentoBase = super.calcularAlimentoBase();
        if (edad < 8) { // Menos de 8 meses
            alimentoBase *= 1.2;
        }
        return alimentoBase;
    }
    
    @Override
    public void alimentar(double cantidadAlimento) {
        super.alimentar(cantidadAlimento);
        // Simular crecimiento adicional
        if (edad < 12) {
            peso += (cantidadAlimento * 0.02); // Mayor eficiencia de conversión
        }
    }
    
    @Override
    public String obtenerInformacion() {
        String info = super.obtenerInformacion();
        info += String.format(" [Crecimiento: %.2f kg/mes]", tasaCrecimiento);
        if (esReproductor) {
            info += " [Reproductor]";
        }
        return info;
    }
}
