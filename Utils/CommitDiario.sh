#!/bin/bash

# Ruta al repositorio
repositorio="/home/daw/DAW/"

# Tu token de acceso al repositorio
# Tu nombre de usuario y contraseña
usuario="jaavii004"
token="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"
tu_repositorio_url="github.com/Jaavii004/DAW"
# Cambia al directorio del repositorio
cd "$repositorio" || exit

# Hacer commit
git add .
git commit -m "Commit diario $(date +'%d-%m-%Y %H:%M')"

# Push con el token
git push origin main -u "$token"

echo "Commit y push diario completados"

