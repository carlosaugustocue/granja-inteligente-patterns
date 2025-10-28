package com.granjainteligente.patterns.behavioral.state;

public interface IStateAnimal {

    // Se establecen comportamientos que podrán tener los animales
    void alimentar(AnimalContext animal);
    void ejercitarse(AnimalContext animal);
    void trasladarDeCorral(AnimalContext animal, String nuevoCorral);
    void reportarSalud(AnimalContext animal);



    // Se establecen eventos de transición entre estados del animal
    void detectarSintomas(AnimalContext animal);
    void administrarMedicina(AnimalContext animal);
    void recibirChequeoPositivo(AnimalContext animal);
    void iniciarCicloReproductivo(AnimalContext animal);
    void morir(AnimalContext animal);

}
