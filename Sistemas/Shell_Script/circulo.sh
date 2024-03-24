#!/bin/bash

# Función para dibujar un círculo (aproximado)
draw_circle() {
    local radio=$1

    for ((y = -radio; y <= radio; y++)); do
        for ((x = -radio; x <= radio; x++)); do
            if ((x * x + y * y <= radio * radio)); then
                echo -n "*"
            else
                echo -n " "
            fi
        done
        echo
    done
}

# Ejemplo de uso
echo "Círculo:"
draw_circle 5
