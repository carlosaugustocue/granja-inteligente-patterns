package com.granjainteligente.patterns.behavioral.strategy.concretestrategy;

import com.granjainteligente.patterns.behavioral.strategy.PlanAlimentacionDTO;
import com.granjainteligente.patterns.behavioral.strategy.StrategyAlimentacion;

public class EstrategiaAhorro implements StrategyAlimentacion {
    @Override
    public PlanAlimentacionDTO calcularPlan(double baseComidaKg, double baseAguaLitros) {
        // En modo ahorro: 50% de todo, sin clima.
        double comida = baseComidaKg * 0.50;
        double agua = baseAguaLitros * 0.50;
        String clima = "Modo ahorro: Climatización desactivada";

        return new PlanAlimentacionDTO(comida, agua, clima);
    }

    @Override
    public String getNombre() { return "Ahorro"; }
}
