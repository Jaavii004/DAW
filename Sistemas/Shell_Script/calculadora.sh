#!/bin/bash

clear

while true; do
    echo "Calculadora"
    echo "1. Suma"
    echo "2. Resta"
    echo "3. Multiplicación"
    echo "4. División"
    echo "5. Salir"
    read -p "Elige una opción: " opcion

    case $opcion in
        1)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            resultado=$((num1 + num2))
            echo "Resultado: $resultado"
        ;;
        2)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            resultado=$((num1 - num2))
            echo "Resultado: $resultado"
        ;;
        3)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            resultado=$((num1 * num2))
            echo "Resultado: $resultado"
        ;;
        4)
            read -p "Ingrese el primer número: " num1
            read -p "Ingrese el segundo número: " num2
            resultado=$(echo "scale=2; $num1 / $num2" | bc)
            echo "Resultado: $resultado"
        ;;
        5)
            exit 0
        ;;
        *)
            echo "No válido."
        ;;
    esac
done
