#!/bin/bash

# Ruta al repositorio
repositorio="/home/daw/DAW/"

# Tu token de acceso al repositorio
# Tu nombre de usuario y contraseña
usuario="jaavii004"
contrasena="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"
tu_repositorio_url=""
# Cambia al directorio del repositorio
cd "$repositorio" || exit

# Hacer commit
git add .
git commit -m "Commit diario $(date +'%d-%m-%Y %H:%M')"

# Push con el token
 
git push  "https://$usuario:$contrasena@$tu_repositorio_url"

echo "Commit y push diario completados"
