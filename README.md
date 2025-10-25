# 🚜 Granja Inteligente - Patrones de Diseño

Sistema de simulación de granja inteligente que implementa los principales patrones de diseño de software.

## 📋 Descripción

Este proyecto es un laboratorio práctico que aplica patrones creacionales, estructurales y comportamentales en el contexto de una granja automatizada. El sistema gestiona animales (vacas, cerdos, gallinas) mediante sensores, dispensadores automáticos y software de control.

## 🎯 Objetivos

- Aplicar patrones de diseño de software en un contexto real
- Integrar múltiples patrones en un flujo funcional coherente
- Desarrollar soluciones escalables y mantenibles
- Documentar la arquitectura y justificar decisiones de diseño

## 🛠️ Tecnologías

- **Lenguaje:** Java 21
- **Build Tool:** Maven 3.9+
- **Testing:** JUnit 5
- **Logging:** SLF4J + Logback
- **Utilidades:** Lombok

## 📦 Estructura del Proyecto

```
granja-inteligente-patterns/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/granjainteligente/
│   │   │       ├── Main.java
│   │   │       ├── models/           # Entidades del dominio
│   │   │       ├── patterns/         # Implementación de patrones
│   │   │       │   ├── creational/   # Factory, Builder, Singleton
│   │   │       │   ├── structural/   # Adapter, Decorator, Facade
│   │   │       │   └── behavioral/   # Observer, Strategy, Command, State
│   │   │       └── services/         # Lógica de negocio
│   │   └── resources/
│   │       └── logback.xml          # Configuración de logs
│   └── test/
│       └── java/
│           └── com/granjainteligente/
│               └── patterns/         # Tests unitarios
├── docs/                             # Documentación y diagramas UML
├── pom.xml                          # Configuración Maven
├── README.md                        # Este archivo
└── .gitignore                       # Archivos ignorados por Git
```

## 🚀 Instalación

### Requisitos Previos

- Java 21 o superior
- Maven 3.9 o superior
- Git

### Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/granja-inteligente-patterns.git
cd granja-inteligente-patterns
```

### Compilar el Proyecto

```bash
mvn clean compile
```

### Ejecutar Tests

```bash
mvn test
```

### Ejecutar la Aplicación

```bash
mvn exec:java -Dexec.mainClass="com.granjainteligente.Main"
```

## 📐 Patrones Implementados

### Patrones Creacionales
- **Factory Method:** Creación dinámica de animales
- **Abstract Factory:** Familias de objetos compatibles
- **Builder:** Construcción modular de objetos complejos
- **Singleton:** Instancia única del alimentador global

### Patrones Estructurales
- **Adapter:** Compatibilidad con sensores legacy
- **Decorator:** Características adicionales dinámicas
- **Facade:** Interfaz simplificada del sistema

### Patrones Comportamentales
- **Observer:** Notificaciones automáticas de sensores
- **Strategy:** Estrategias de alimentación por estación
- **Command:** Encapsulación de operaciones
- **State:** Estados de salud de animales

## 👥 Equipo de Desarrollo

- [Nombre Integrante 1]
- [Nombre Integrante 2]
- [Nombre Integrante 3]
- [Nombre Integrante 4]

## 🔄 Flujo de Trabajo Git

### Ramas Principales
- `main`: Rama principal con código estable
- `develop`: Rama de desarrollo e integración

### Ramas de Características
- `feature/factory-method`
- `feature/observer-pattern`
- `feature/strategy-pattern`
- etc.

### Proceso de Contribución
1. Crear rama desde `develop`
2. Implementar la funcionalidad
3. Hacer commit con mensajes descriptivos
4. Crear Pull Request hacia `develop`
5. Code review por otro integrante
6. Merge tras aprobación

## 📊 Criterios de Evaluación

| Criterio | Ponderación |
|----------|-------------|
| Patrones Creacionales | 20% |
| Patrones Estructurales | 20% |
| Patrones Comportamentales | 25% |
| Integración Funcional | 20% |
| Documentación | 15% |

## 📝 Licencia

Este proyecto es desarrollado con fines educativos.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:
1. Fork el proyecto
2. Crea una rama para tu feature
3. Commit tus cambios
4. Push a la rama
5. Abre un Pull Request

## 📧 Contacto

Para preguntas o sugerencias, contactar al equipo de desarrollo.

---
*Desarrollado como parte del Laboratorio de Programación Orientada a Objetos y Patrones de Diseño*
