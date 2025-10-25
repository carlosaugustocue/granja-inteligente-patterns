package com.granjainteligente.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementación concreta de una Gallina.
 */
@Getter
@Setter
public class Gallina extends AnimalBase {
    
    private boolean esPonedora;
    private int huevosPorSemana;
    private String colorPlumaje;
    
    public Gallina(double peso, int edad) {
        super(TipoAnimal.GALLINA, peso, edad);
        this.esPonedora = true;
        this.huevosPorSemana = calcularProduccionHuevos();
        this.colorPlumaje = "Marrón";
        this.raza = "Rhode Island"; // Raza por defecto
    }
    
    public Gallina(double peso, int edad, String raza, boolean esPonedora, String colorPlumaje) {
        super(TipoAnimal.GALLINA, peso, edad);
        this.raza = raza;
        this.esPonedora = esPonedora;
        this.colorPlumaje = colorPlumaje;
        this.huevosPorSemana = esPonedora ? calcularProduccionHuevos() : 0;
    }
    
    /**
     * Calcula la producción de huevos basada en edad y estado de salud.
     * @return Número de huevos por semana
     */
    private int calcularProduccionHuevos() {
        if (!esPonedora || edad < 5) { // Las gallinas empiezan a poner a los 5 meses
            return 0;
        }
        
        int produccionBase = 5; // 5 huevos por semana promedio
        
        // Mejor producción entre 6 y 24 meses
        if (edad >= 6 && edad <= 24) {
            produccionBase = 6;
        } else if (edad > 36) {
            produccionBase = 3; // Reducción después de 3 años
        }
        
        // Factor de salud
        double factorSalud = estadoSalud.getFactorAlimentacion();
        
        return (int) (produccionBase * factorSalud);
    }
    
    @Override
    public String hacerSonido() {
        return "¡Coc coc coc! 🐔";
    }
    
    @Override
    protected double calcularAlimentoBase() {
        // Las gallinas comen menos que otros animales
        return peso * 0.015; // 1.5% del peso corporal
    }
    
    @Override
    public void alimentar(double cantidadAlimento) {
        super.alimentar(cantidadAlimento);
        // Recalcular producción de huevos después de alimentar
        if (esPonedora) {
            huevosPorSemana = calcularProduccionHuevos();
        }
    }
    
    /**
     * Simula la recolección de huevos.
     * @return Número de huevos recolectados
     */
    public int recolectarHuevos() {
        int huevosRecolectados = huevosPorSemana / 7; // Producción diaria
        return Math.max(0, huevosRecolectados);
    }
    
    @Override
    public String obtenerInformacion() {
        String info = super.obtenerInformacion();
        info += String.format(" [Color: %s]", colorPlumaje);
        if (esPonedora) {
            info += String.format(" [Huevos/sem: %d]", huevosPorSemana);
        }
        return info;
    }
}
