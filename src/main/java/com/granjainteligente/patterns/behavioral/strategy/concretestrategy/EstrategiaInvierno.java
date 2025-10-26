package com.granjainteligente.patterns.behavioral.strategy.concretestrategy;

import com.granjainteligente.patterns.behavioral.strategy.PlanAlimentacionDTO;
import com.granjainteligente.patterns.behavioral.strategy.StrategyAlimentacion;

public class EstrategiaInvierno implements StrategyAlimentacion {
    @Override
    public PlanAlimentacionDTO calcularPlan(double baseComidaKg, double baseAguaLitros) {
        // En invierno: 20% más comida, misma agua, calefacción.
        double comida = baseComidaKg * 1.20;
        double agua = baseAguaLitros; // Misma agua
        String clima = "Activando calefacción de agua a 15°C";

        return new PlanAlimentacionDTO(comida, agua, clima);
    }

    @Override
    public String getNombre() { return "Invierno"; }
}
