package com.granjainteligente.models;

/**
 * Interfaz base para todos los animales de la granja.
 * Define las operaciones comunes que todos los animales deben implementar.
 */
public interface Animal {
    
    /**
     * Obtiene el identificador único del animal.
     * @return ID del animal
     */
    String getId();
    
    /**
     * Obtiene el tipo de animal.
     * @return Tipo del animal (VACA, CERDO, GALLINA, etc.)
     */
    TipoAnimal getTipo();
    
    /**
     * Obtiene el peso actual del animal.
     * @return Peso en kilogramos
     */
    double getPeso();
    
    /**
     * Establece el peso del animal.
     * @param peso Nuevo peso en kilogramos
     */
    void setPeso(double peso);
    
    /**
     * Obtiene la edad del animal.
     * @return Edad en meses
     */
    int getEdad();
    
    /**
     * Alimenta al animal con la cantidad especificada.
     * @param cantidadAlimento Cantidad de alimento en kilogramos
     */
    void alimentar(double cantidadAlimento);
    
    /**
     * Obtiene el estado de salud actual del animal.
     * @return Estado de salud
     */
    EstadoSalud getEstadoSalud();
    
    /**
     * Cambia el estado de salud del animal.
     * @param nuevoEstado Nuevo estado de salud
     */
    void setEstadoSalud(EstadoSalud nuevoEstado);
    
    /**
     * Produce el sonido característico del animal.
     * @return String con el sonido del animal
     */
    String hacerSonido();
    
    /**
     * Obtiene información detallada del animal.
     * @return String con la información del animal
     */
    String obtenerInformacion();
}
