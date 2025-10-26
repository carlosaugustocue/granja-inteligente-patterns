package com.granjainteligente.patterns.structural.decorator;

import com.granjainteligente.models.Animal;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Decorador que añade funcionalidad de control de vacunación a un animal.
 * Permite registrar vacunas aplicadas y verificar el estado de vacunación.
 */
@Slf4j
@Getter
public class AnimalConVacuna extends AnimalDecorator {

    private final List<RegistroVacuna> historicoVacunas;
    private LocalDate ultimaVacuna;

    public AnimalConVacuna(Animal animalDecorado) {
        super(animalDecorado);
        this.historicoVacunas = new ArrayList<>();
        this.ultimaVacuna = null;
        log.info("Decorador de vacunación aplicado al animal: {}", animalDecorado.getId());
    }

    /**
     * Registra una nueva vacuna aplicada al animal.
     * @param nombreVacuna Nombre de la vacuna
     * @param dosis Dosis aplicada
     */
    public void aplicarVacuna(String nombreVacuna, String dosis) {
        RegistroVacuna registro = new RegistroVacuna(
                nombreVacuna,
                dosis,
                LocalDate.now()
        );
        historicoVacunas.add(registro);
        ultimaVacuna = LocalDate.now();
        log.info("Vacuna '{}' aplicada al animal {} (Dosis: {})",
                nombreVacuna, getId(), dosis);
    }

    /**
     * Verifica si el animal tiene la vacuna al día (dentro de los últimos 6 meses).
     * @return true si está vacunado, false en caso contrario
     */
    public boolean estaVacunado() {
        if (ultimaVacuna == null) {
            return false;
        }
        // Considerar vacunado si fue en los últimos 6 meses
        LocalDate hace6Meses = LocalDate.now().minusMonths(6);
        return ultimaVacuna.isAfter(hace6Meses);
    }

    /**
     * Obtiene el número total de vacunas aplicadas.
     * @return Cantidad de vacunas
     */
    public int getCantidadVacunas() {
        return historicoVacunas.size();
    }

    /**
     * Obtiene el historial completo de vacunación.
     * @return String con el historial
     */
    public String obtenerHistorialVacunas() {
        if (historicoVacunas.isEmpty()) {
            return "Sin vacunas registradas";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Historial de vacunación:\n");
        for (RegistroVacuna registro : historicoVacunas) {
            sb.append(String.format("  - %s (Dosis: %s) - Fecha: %s\n",
                    registro.nombreVacuna,
                    registro.dosis,
                    registro.fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        }
        return sb.toString();
    }

    @Override
    public String obtenerInformacion() {
        String infoBase = super.obtenerInformacion();
        String estadoVacunacion = estaVacunado() ? "AL DÍA" : "PENDIENTE";
        return infoBase + String.format(" [Vacunación: %s (%d aplicadas)]",
                estadoVacunacion, getCantidadVacunas());
    }

    /**
     * Clase interna para representar un registro de vacuna.
     */
    @Getter
    public static class RegistroVacuna {
        private final String nombreVacuna;
        private final String dosis;
        private final LocalDate fecha;

        public RegistroVacuna(String nombreVacuna, String dosis, LocalDate fecha) {
            this.nombreVacuna = nombreVacuna;
            this.dosis = dosis;
            this.fecha = fecha;
        }
    }
}
