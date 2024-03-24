#!/bin/bash

# Función para dibujar un cuadrado
draw_square() {
    local lado=$1

    for ((i = 1; i <= lado; i++)); do
        for ((j = 1; j <= lado; j++)); do
            echo -n "*"
        done
        echo
    done
}

# Ejemplo de uso
echo "Cuadrado:"
draw_square 5
