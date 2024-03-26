#!/bin/bash

opcion=0

mostrar_menu () {
    echo "1. Dibujar piramide en piramide.txt"
    echo "2. Mostrar piramide.txt"
    echo "3. rotar piramide.txt"
    echo "4. contar asteriscos"
    echo "5. Sustituir"
    echo "6. Salir"
}


triangulo_invertido() {
    triangulo_normal
    # este comando lo que hace es leer el archivo del reves empieza por el final 
    # y acaba por la primera linea (Lo he utilizado en smx) que es un cat al reves
    tac piramide.txt > tmp.txt
    cat tmp.txt > piramide.txt
    rm tmp.txt
}

triangulo_normal() {
    if [ -f piramide.txt ];then
        echo -n > piramide.txt
    else
        touch piramide.txt
    fi
    read -p "Altura: " altura
    for j in $(seq 1 $altura); do
        for ((i = $altura; i >= $j; i--)); do
            echo -n " " >> piramide.txt
        done
        for ((i = 1; i <= $j; i++)); do
            echo -n "*" >> piramide.txt
        done
        for ((i = 2; i <= $j; i++)); do
            echo -n "*" >> piramide.txt
        done
        echo >> piramide.txt
    done
}

contar_asteriscos() {
    # aqui se cuantas lineas hay y se cuantos espacios quedan para restarlos
    espacios=$(cat piramide.txt | wc -l)
    numi=$(cat piramide.txt | tr -s " " | wc -c)
    echo "$numi-$espacios" | bc
}


sustituir(){
    read -p " Por que lo quieres sustituir? " sus
    cat piramide.txt | tr "*" "$sus" > tmp
    cat tmp > piramide.txt
    rm tmp
}

mostrar_piramide() {
    if [ -f piramide.txt ]; then
        echo "Aqui tienes la piramide"
        cat piramide.txt
    else
        echo "El archivo piramide.txt no existe dale primero al 1."
    fi
}

clear

while [ $opcion != 6 ]; do
    mostrar_menu
    read -p "Que opcion quieres: " opcion
    clear
    case $opcion in
        1) 
            triangulo_invertido
        ;;
        2)
            mostrar_piramide
            read -p "Pulsa enter para continuar"
        ;;
        3) 
            triangulo_normal
        ;;
        4) 
            contar_asteriscos
        ;;
        5) 
            sustituir
        ;;
        6) 
            echo "Salir"
        ;;
        *)
            echo "Opción inválida"
            opcion=10
        ;;
    esac
done

exit 0