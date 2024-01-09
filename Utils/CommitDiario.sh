#!/bin/bash

# Ruta al repositorio
repositorio="/home/daw/DAW/"

# Tu token de acceso al repositorio
token="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"

# Cambia al directorio del repositorio
cd "$repositorio" || exit

# Hacer commit
git add .
git commit -m "Commit diario $(date +'%Y-%m-%d %H:%M:%S')"

# Push con el token
git push origin main -u Jaavii004 -u "$token"

echo "Commit y push diario completados"