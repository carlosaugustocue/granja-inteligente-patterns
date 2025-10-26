package com.granjainteligente.patterns.behavioral.strategy.concretestrategy;

import com.granjainteligente.patterns.behavioral.strategy.PlanAlimentacionDTO;
import com.granjainteligente.patterns.behavioral.strategy.StrategyAlimentacion;

public class EstrategiaVerano implements StrategyAlimentacion {
    @Override
    public PlanAlimentacionDTO calcularPlan(double baseComidaKg, double baseAguaLitros) {
        // En verano: 10% menos comida, 50% más agua, ventilación.
        double comida = baseComidaKg * 0.90;
        double agua = baseAguaLitros * 1.50;
        String clima = "Activando ventiladores y sombra";

        return new PlanAlimentacionDTO(comida, agua, clima);
    }

    @Override
    public String getNombre() { return "Verano"; }
}
