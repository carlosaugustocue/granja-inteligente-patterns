package com.granjainteligente.patterns.behavioral.strategy;

public interface StrategyAlimentacion {

    // Se calcula el plan de alimentación basado en las cantidades base.
    PlanAlimentacionDTO calcularPlan(double baseComidaKg, double baseAguaLitros);


    // Un método simple para saber el nombre de la estrategia actual.
    String getNombre();

}
