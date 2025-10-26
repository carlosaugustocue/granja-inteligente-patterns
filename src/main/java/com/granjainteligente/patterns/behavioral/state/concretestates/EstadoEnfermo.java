package com.granjainteligente.patterns.behavioral.state.concretestates;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;
import com.granjainteligente.patterns.behavioral.state.IStateAnimal;

public class EstadoEnfermo  implements IStateAnimal {
    @Override
    public void alimentar(AnimalContext animal) {
        System.out.printf(
                "ALIMENTACIÓN: [%s] (Enfermo) NO tiene apetito. Come %.2f kg.\n",
                animal.getNombre(),
                animal.getCantidadComidaBaseKg() * 0.1 // Come solo el 10%
        );
    }

    @Override
    public void ejercitarse(AnimalContext animal) {
        System.out.printf("EJERCICIO: [%s] (Enfermo) está tumbado y no se mueve.\n", animal.getNombre());
    }

    @Override
    public void trasladarDeCorral(AnimalContext animal, String nuevoCorral) {
        if (nuevoCorral.equals("Cuarentena")) {
            System.out.printf(
                    "TRASLADO: [%s] (Enfermo) se traslada a %s.\n",
                    animal.getNombre(),
                    nuevoCorral
            );
        } else {
            System.out.printf(
                    "TRASLADO: NO PUEDE trasladarse a corrales comunes. ¡Riesgo de contagio!\n",
                    animal.getNombre()
            );
        }
    }

    @Override
    public void reportarSalud(AnimalContext animal) {
        System.out.printf("REPORTE: [%s] está Enfermo (Fiebre, tos).\n", animal.getNombre());
    }




    // --- Transiciones desde Enfermo ---
    @Override
    public void detectarSintomas(AnimalContext animal) {
        System.out.println("El animal se encuentra enfermo.");
    }

    @Override
    public void administrarMedicina(AnimalContext animal) {
        // ¡Transición!
        animal.setEstado(new EstadoTratamiento());
    }

    @Override
    public void recibirChequeoPositivo(AnimalContext animal) {
        System.out.println("No se puede curar sin tratamiento.");
    }

    @Override
    public void iniciarCicloReproductivo(AnimalContext animal) {
        System.out.println("Un animal Enfermo no puede aparearse.");
    }

    @Override
    public void morir(AnimalContext animal) {
        animal.setEstado(new EstadoMuerto());
    }
}
