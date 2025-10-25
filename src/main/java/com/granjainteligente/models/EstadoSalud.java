package com.granjainteligente.models;

/**
 * Enumeración que define los posibles estados de salud de un animal.
 */
public enum EstadoSalud {
    SANO("Sano", "El animal está en perfecto estado de salud", 1.0),
    ENFERMO("Enfermo", "El animal requiere atención veterinaria", 0.5),
    EN_TRATAMIENTO("En Tratamiento", "El animal está recibiendo cuidados médicos", 0.7),
    CONVALECIENTE("Convaleciente", "El animal se está recuperando", 0.8),
    CRITICO("Crítico", "El animal requiere atención urgente", 0.3);
    
    private final String nombre;
    private final String descripcion;
    private final double factorAlimentacion;
    
    EstadoSalud(String nombre, String descripcion, double factorAlimentacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.factorAlimentacion = factorAlimentacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Factor que afecta la cantidad de alimentación según el estado de salud.
     * @return Factor multiplicador (0.0 - 1.0)
     */
    public double getFactorAlimentacion() {
        return factorAlimentacion;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
