package com.granjainteligente.patterns.behavioral.state.concretestates;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;
import com.granjainteligente.patterns.behavioral.state.IStateAnimal;

public class EstadoApareamiento implements IStateAnimal {
    @Override
    public void alimentar(AnimalContext animal) {
        System.out.printf(
                "ALIMENTACIÓN: [%s] (En Apareamiento) come %.2f kg (dieta alta en energía).\n",
                animal.getNombre(),
                animal.getCantidadComidaBaseKg() * 1.15 // Come 115% (dieta especial)
        );
    }

    @Override
    public void ejercitarse(AnimalContext animal) {
        System.out.printf("EJERCICIO: [%s] (En Apareamiento) realiza ejercicio moderado.\n", animal.getNombre());
    }

    @Override
    public void trasladarDeCorral(AnimalContext animal, String nuevoCorral) {
        if (nuevoCorral.contains("Cria")) {
            System.out.printf(
                    "MOVILIDAD: [%s] (En Apareamiento) se traslada a la zona de %s.\n",
                    animal.getNombre(),
                    nuevoCorral
            );
        } else {
            System.out.printf(
                    "TRASLADO: [%s] (En Apareamiento) no debe ser molestado. Permanece en su corral.\n",
                    animal.getNombre()
            );
        }
    }

    @Override
    public void reportarSalud(AnimalContext animal) {
        System.out.printf("REPORTE: [%s] está Sano (En ciclo reproductivo).\n", animal.getNombre());
    }

    // --- Transiciones desde Apareamiento ---

    @Override
    public void detectarSintomas(AnimalContext animal) {
        // Un animal en apareamiento también puede enfermarse
        System.out.printf("ALERTA: [%s] (En Apareamiento) muestra síntomas. Ciclo interrumpido.\n", animal.getNombre());
        animal.setEstado(new EstadoEnfermo()); // Transición a Enfermo
    }

    @Override
    public void administrarMedicina(AnimalContext animal) {
        System.out.println("MEDICACIÓN: No se puede medicar, el animal no está enfermo.");
    }

    @Override
    public void recibirChequeoPositivo(AnimalContext animal) {
        // Esta es la transición de salida: el ciclo terminó.
        System.out.printf("ÉXITO: [%s] ha completado su ciclo reproductivo. Vuelve a estado Sano.\n", animal.getNombre());
        animal.setEstado(new EstadoSano()); // Vuelve a Sano
    }

    @Override
    public void iniciarCicloReproductivo(AnimalContext animal) {
        System.out.printf("REPRODUCIR: [%s] ya se encuentra en un ciclo reproductivo.\n", animal.getNombre());
    }

    @Override
    public void morir(AnimalContext animal) {
        System.out.printf("ALERTA: [%s] murió durante el ciclo reproductivo.\n", animal.getNombre());
        animal.setEstado(new EstadoMuerto()); // Transición a Muerto
    }
}
