package com.granjainteligente.patterns.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton responsable de gestionar todos los dispensadores de alimento de la granja.
 *
 * Garantiza que solo exista una instancia global de este administrador
 * y proporciona métodos sincronizados para operaciones seguras entre hilos.
 */

@Slf4j
public class AlimentadorGlobal {

    //  Instancia única (volatile para garantizar visibilidad entre hilos)
    private static volatile AlimentadorGlobal instancia;

    private final Map<String, Dispensador> dispensadores;
    private String horarioProgramado;

    /** Constructor privado para evitar instanciación externa */
    private AlimentadorGlobal() {
        this.dispensadores = new HashMap<>();
        this.horarioProgramado = "08:00, 12:00, 18:00";
        System.out.println("✅ AlimentadorGlobal inicializado (Singleton)");
    }

    /**
     * Obtiene la instancia única del AlimentadorGlobal.
     * Usa doble verificación (Double-Checked Locking) para rendimiento y seguridad.
     */
    public static AlimentadorGlobal getInstancia() {
        if (instancia == null) {
            synchronized (AlimentadorGlobal.class) {
                if (instancia == null) {
                    instancia = new AlimentadorGlobal();
                }
            }
        }
        return instancia;
    }

    /** Registra un nuevo dispensador en el sistema global. */
    public synchronized void registrarDispensador(String id, Dispensador dispensador) {
        dispensadores.put(id, dispensador);
        System.out.printf("➕ Dispensador %s registrado%n", id);
    }

    /** Ejecuta la alimentación de un corral específico. */
    public synchronized void alimentarCorral(String id, double cantidad) {
        Dispensador d = dispensadores.get(id);
        if (d != null) {
            d.dispensar(cantidad);
        } else {
            System.out.printf("✗ No existe dispensador con ID '%s'%n", id);
        }
    }

    /** Verifica niveles de todos los dispensadores. */
    public synchronized void verificarNiveles() {
        System.out.println("\n🔍 Niveles de alimento:");
        dispensadores.values().forEach(d -> {
            double porcentaje = d.getPorcentajeOcupacion();
            String estado = porcentaje < 20 ? "⚠️ Bajo" : "✓ OK";
            System.out.printf(" - %s: %.2f%% (%s)%n", d.getId(), porcentaje, estado);
        });
    }

    /** Recarga automáticamente dispensadores con nivel < 30%. */
    public synchronized void recargaAutomatica() {
        System.out.println("\n🔄 Iniciando recarga automática:");
        dispensadores.values().stream()
                .filter(d -> d.getPorcentajeOcupacion() < 30)
                .forEach(Dispensador::recargar);
    }

    /** Programar horario global de alimentación. */
    public void programarAlimentacion(String horario) {
        this.horarioProgramado = horario;
        System.out.printf("📅 Alimentación programada: %s%n", horario);
    }

    /** Obtiene una copia inmutable del mapa de dispensadores. */
    public Map<String, Dispensador> getDispensadores() {
        return Collections.unmodifiableMap(dispensadores);
    }

    public String getHorarioProgramado() {
        return horarioProgramado;
    }
}
