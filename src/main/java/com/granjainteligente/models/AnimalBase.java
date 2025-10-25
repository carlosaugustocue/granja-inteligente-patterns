package com.granjainteligente.models;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

/**
 * Clase abstracta base que implementa las funcionalidades comunes de todos los animales.
 */
@Slf4j
@Getter
@Setter
public abstract class AnimalBase implements Animal {
    
    protected String id;
    protected TipoAnimal tipo;
    protected double peso;
    protected int edad; // en meses
    protected EstadoSalud estadoSalud;
    protected double cantidadAlimentoDiario;
    protected String raza;
    
    /**
     * Constructor base para todos los animales.
     */
    protected AnimalBase(TipoAnimal tipo, double peso, int edad) {
        this.id = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.peso = peso;
        this.edad = edad;
        this.estadoSalud = EstadoSalud.SANO;
        this.cantidadAlimentoDiario = calcularAlimentoBase();
    }
    
    /**
     * Calcula la cantidad base de alimento diario según el tipo y peso del animal.
     * @return Cantidad de alimento en kg
     */
    protected double calcularAlimentoBase() {
        // Fórmula básica: 2-3% del peso corporal
        return peso * 0.025;
    }
    
    @Override
    public void alimentar(double cantidadAlimento) {
        double cantidadAjustada = cantidadAlimento * estadoSalud.getFactorAlimentacion();
        log.info("Alimentando {} {} con {} kg de alimento", 
                tipo.getNombre(), id, cantidadAjustada);
        
        // Simular efecto del alimento en el peso
        peso += cantidadAjustada * 0.01; // Conversión simplificada
    }
    
    @Override
    public void setEstadoSalud(EstadoSalud nuevoEstado) {
        log.info("Cambiando estado de salud de {} de {} a {}", 
                id, this.estadoSalud, nuevoEstado);
        this.estadoSalud = nuevoEstado;
    }
    
    @Override
    public String obtenerInformacion() {
        return String.format(
            "Animal[ID=%s, Tipo=%s, Raza=%s, Peso=%.2f kg, Edad=%d meses, Salud=%s]",
            id, tipo, raza != null ? raza : "Mixta", peso, edad, estadoSalud
        );
    }
    
    @Override
    public String toString() {
        return obtenerInformacion();
    }
}
