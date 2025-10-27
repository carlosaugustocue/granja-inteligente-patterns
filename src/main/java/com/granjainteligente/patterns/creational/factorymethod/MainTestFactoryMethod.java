package com.granjainteligente.patterns.creational.factorymethod;

import com.granjainteligente.models.Animal;

import com.granjainteligente.models.TipoAnimal;




public class MainTestFactoryMethod {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MainTestFactoryMethod.class);

    public static void main(String[] args) {


        AnimalFactory CorralVacas = AnimalFactoryProvider.getFactory(TipoAnimal.VACA);
        AnimalFactory CorralCerdo = AnimalFactoryProvider.getFactory(TipoAnimal.CERDO);
        AnimalFactory CorralGallina = AnimalFactoryProvider.getFactory(TipoAnimal.GALLINA);

        Animal vaca = CorralVacas.crear(550, 36);
        Animal cerdo = CorralCerdo.crear(120, 8);
        Animal gallina = CorralGallina.crear(2.3, 10);

        log.info("Vaca: {}", vaca.obtenerInformacion());
        log.info("Cerdo: {}", cerdo.obtenerInformacion());
        log.info("Gallina: {}", gallina.obtenerInformacion());

    }

}
