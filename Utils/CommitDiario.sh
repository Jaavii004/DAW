#!/bin/bash

# Ruta al repositorio
repositorio="/home/daw/DAW/"

# Cambia al directorio del repositorio
cd "$repositorio" || exit

echo "Commit diario $(date +'%d-%m-%Y %H:%M')" >> Commit.txt

# Hacer commit
git add .
git commit -m "Commit diario $(date +'%d-%m-%Y %H:%M')"


echo "Commit diario completados"

