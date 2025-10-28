package com.granjainteligente.patterns.behavioral.state.concretestates;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;
import com.granjainteligente.patterns.behavioral.state.IStateAnimal;

public class EstadoTratamiento implements IStateAnimal {

    @Override
    public void alimentar(AnimalContext animal) {
        System.out.printf(
                "ALIMENTACIÓN: [%s] (En Tratamiento) recupera el apetito. Come %.2f kg (dieta de recuperación).\n",
                animal.getNombre(),
                animal.getCantidadComidaBaseKg() * 0.75 // Come el 75%
        );
    }

    @Override
    public void ejercitarse(AnimalContext animal) {
        System.out.printf("EJERCICIO: [%s] (En Tratamiento) realiza caminatas ligeras de recuperación.\n", animal.getNombre());
    }

    @Override
    public void trasladarDeCorral(AnimalContext animal, String nuevoCorral) {
        // Un animal en tratamiento no podrá ser trasladado a un corral normal
        if (nuevoCorral.equals("Cuarentena")) {
            System.out.printf(
                    "TRASLADO: [%s] (En Tratamiento) permanece en %s.\n",
                    animal.getNombre(),
                    nuevoCorral
            );
        } else {
            System.out.printf(
                    "TRASLADO: [%s] (En Tratamiento) debe completar su recuperación en 'Cuarentena' antes de moverse.\n",
                    animal.getNombre()
            );
        }
    }

    @Override
    public void reportarSalud(AnimalContext animal) {
        System.out.printf("REPORTE: [%s] está En Tratamiento y recuperándose.\n", animal.getNombre());
    }



    // Transiciones desde Tratamiento

    @Override
    public void detectarSintomas(AnimalContext animal) {
        // El animal puede tener una recaída
        System.out.println("ALERTA: [%s] ha sufrido una RECAÍDA." + animal.getNombre());
        animal.setEstado(new EstadoEnfermo()); // Vuelve a Enfermo
    }

    @Override
    public void administrarMedicina(AnimalContext animal) {
        // No hay cambio de estado, solo se reafirma
        System.out.printf("LOG: [%s] continúa su tratamiento con éxito.\n", animal.getNombre());
    }

    @Override
    public void recibirChequeoPositivo(AnimalContext animal) {
        // El animal se recupera
        System.out.printf("ÉXITO: [%s] ha completado el tratamiento y está Sano.\n", animal.getNombre());
        animal.setEstado(new EstadoSano()); // Vuelve a Sano
    }

    @Override
    public void iniciarCicloReproductivo(AnimalContext animal) {
        // Se intenta reproducir al animal con tratamiento
        System.out.println("ERROR: Un animal En Tratamiento no puede aparearse.");
    }

    @Override
    public void morir(AnimalContext animal) {
        // El tratamiento puede fallar y ocasionar la muerte del animal
        System.out.printf("FALLO: [%s] no resistió el tratamiento.\n", animal.getNombre());
        animal.setEstado(new EstadoMuerto()); // Transición a Muerto
    }
}
