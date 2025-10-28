package com.granjainteligente.patterns.behavioral.strategy;


/**
 * DTO que nos ayudara a simular el encapsulamiento del resultado
 * de una estrategia de alimentación.
 */
public record PlanAlimentacionDTO (
        double cantidadComidaKg,
        double cantidadAguaLitros,
        String accionClimatizacion
) {}
