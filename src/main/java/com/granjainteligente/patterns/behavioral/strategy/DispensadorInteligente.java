package com.granjainteligente.patterns.behavioral.strategy;

import com.granjainteligente.patterns.behavioral.strategy.concretestrategy.EstrategiaVerano;




public class DispensadorInteligente {
    private final String idCorral;
    private final String tipoAnimal;
    private final double baseComidaKg;
    private final double baseAguaLitros;

    // La variable del patrón Strategy
    // Almacena una referencia a la estrategia actual.
    private StrategyAlimentacion estrategiaActual;

    public DispensadorInteligente(String idCorral, String tipoAnimal, double baseComidaKg, double baseAguaLitros) {
        this.idCorral = idCorral;
        this.tipoAnimal = tipoAnimal;
        this.baseComidaKg = baseComidaKg;
        this.baseAguaLitros = baseAguaLitros;

        // Por defecto se decide empezar con una estrategia base como verano
        this.estrategiaActual = new EstrategiaVerano();
    }

    /**
     * Este metodo nos permite cambiar la estrategia del dispensador en tiempo de ejecución.
     *
     */
    public void setEstrategia(StrategyAlimentacion nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
        System.out.printf(
                "INFO: Dispensador [%s - %s] cambiando a estrategia: %s\n",
                this.tipoAnimal,
                this.idCorral,
                this.estrategiaActual.getNombre()
        );
    }

    /**
     * Este metodo ejecuta la lógica de alimentación, delegando el cálculo
     * a la estrategia que esté activa en este momento.
     */
    public void ejecutarPlanAlimentacion() {
        System.out.printf(
                "\n--- Ejecutando Plan en [%s - %s] (Estrategia: %s) ---\n",
                this.tipoAnimal,
                this.idCorral,
                this.estrategiaActual.getNombre()
        );


        // Aqui el dispensador llama al método de la interfaz IEstrategiaAlimentacion.
        // Con esto logramos ejecutar la versión concreta del método calcularPlan que esté almacenada en estrategiaActual.
        PlanAlimentacionDTO plan = this.estrategiaActual.calcularPlan(baseComidaKg, baseAguaLitros);

        // Simulación de los actuadores del dispensador
        System.out.printf("* Dispensando %.2f kg de comida.\n", plan.cantidadComidaKg());
        System.out.printf("* Suministrando %.2f L de agua.\n", plan.cantidadAguaLitros());
        System.out.printf("* Climatización: %s.\n", plan.accionClimatizacion());
        System.out.println("--------------------------------------------------\n");
    }
}
