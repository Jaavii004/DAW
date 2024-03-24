#!/bin/bash

# Función para dibujar un triángulo equilátero
dibujar_triangulo_equilatero() {
    local altura=$1
    local ancho=$((2 * altura - 1))

    for ((i = 1; i <= altura; i++)); do
        for ((j = 1; j <= ancho; j++)); do
            if [ $((j + i)) -ge $((altura + 1)) ] && [ $((j - i)) -le $((altura - 1)) ]; then
                echo -n "*"
            else
                echo -n " "
            fi
        done
        echo
    done
}

# Función para dibujar un triángulo rectángulo hacia la derecha
dibujar_triangulo_derecha() {
    local altura=$1

    for ((i = 1; i <= altura; i++)); do
        for ((j = 1; j <= i; j++)); do
            echo -n "*"
        done
        echo
    done
}

# Función para dibujar un triángulo rectángulo hacia la izquierda
dibujar_triangulo_izquierda() {
    local altura=$1

    for ((i = 1; i <= altura; i++)); do
        for ((j = altura; j >= 1; j--)); do
            if [ $j -le $i ]; then
                echo -n "*"
            else
                echo -n " "
            fi
        done
        echo
    done
}

# Función para dibujar un triángulo invertido
dibujar_triangulo_invertido() {
    local altura=$1

    for ((i = altura; i >= 1; i--)); do
        for ((j = 1; j <= (2 * altura - 1); j++)); do
            if [ $((j + i)) -ge $((altura + 1)) ] && [ $((j - i)) -le $((altura - 1)) ]; then
                echo -n "*"
            else
                echo -n " "
            fi
        done
        echo
    done
}

# Ejemplo de uso
echo "Triángulo equilátero:"
dibujar_triangulo_equilatero 5

echo -e "\nTriángulo rectángulo hacia la derecha:"
dibujar_triangulo_derecha 5

echo -e "\nTriángulo rectángulo hacia la izquierda:"
dibujar_triangulo_izquierda 5

echo -e "\nTriángulo invertido:"
dibujar_triangulo_invertido 5
