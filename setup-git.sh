#!/bin/bash

# Script de inicialización del repositorio
# Uso: ./setup-git.sh <url-del-repositorio>

echo "==================================================="
echo "   CONFIGURACIÓN DEL REPOSITORIO GRANJA INTELIGENTE"
echo "==================================================="
echo ""

# Verificar si se proporcionó la URL del repositorio
if [ -z "$1" ]; then
    echo "❌ Error: Debes proporcionar la URL del repositorio"
    echo "Uso: ./setup-git.sh https://github.com/tu-usuario/granja-inteligente-patterns.git"
    exit 1
fi

REPO_URL=$1

echo "📁 Inicializando repositorio Git..."
git init

echo "✅ Agregando archivos al staging area..."
git add .

echo "💬 Creando primer commit..."
git commit -m "feat: estructura inicial del proyecto Granja Inteligente

- Configuración de Maven con Java 21
- Estructura de directorios para patrones de diseño
- Modelos base: Animal, Vaca, Cerdo, Gallina
- Enums: TipoAnimal, EstadoSalud
- Configuración de logging con Logback
- Tests unitarios básicos
- Documentación inicial (README.md)"

echo "🏷️  Creando rama principal (main)..."
git branch -M main

echo "🔗 Agregando repositorio remoto..."
git remote add origin $REPO_URL

echo "📤 Subiendo cambios al repositorio remoto..."
git push -u origin main

echo "🌿 Creando rama de desarrollo..."
git checkout -b develop
git push -u origin develop

echo ""
echo "✨ ¡Configuración completada con éxito!"
echo ""
echo "📋 Próximos pasos:"
echo "1. Crear ramas para cada patrón:"
echo "   - git checkout -b feature/factory-method"
echo "   - git checkout -b feature/singleton"
echo "   - git checkout -b feature/observer"
echo "   - etc."
echo ""
echo "2. Asignar tareas a los integrantes del equipo"
echo "3. Comenzar con la implementación de los patrones"
echo ""
echo "🔍 Estado actual:"
git status
echo ""
echo "📊 Ramas disponibles:"
git branch -a
