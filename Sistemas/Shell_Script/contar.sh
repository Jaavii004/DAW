#!/bin/bash

read -p "Introduce el nombre del archivo: " fichero

if [ -f "$fichero" ]; then
    contarPalabras=$(cat $fichero | wc -w)
    echo "El archivo tiene: $contarPalabras palabras."
else
    echo "El archivo '$fichero' no existe o no es legible."
fi

exit