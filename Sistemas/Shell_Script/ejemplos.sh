#!/bin/bash

# Ejemplo de bucle while: 
# Se ejecuta mientras la condición sea verdadera.

echo "Bucle While:"

# Ejemplo 1: Utilizando una condición simple
contador=0
while [ $contador -lt 5 ]; do
    echo "Contador: $contador"
    ((contador++))
done

# Ejemplo 2: Utilizando una condición con comando
archivo_existente="archivo.txt"
while [ -e "$archivo_existente" ]; do
    echo "El archivo $archivo_existente existe."
    sleep 1
done

echo

# Ejemplo de bucle for:
# Se utiliza para iterar sobre una secuencia de elementos.

echo "Bucle For:"

# Ejemplo 1: Iterar sobre una lista definida
for i in 1 2 3 4 5; do
    echo "Número: $i"
done

# Ejemplo 2: Iterar sobre los elementos de un array
nombres=("Juan" "María" "Pedro")
for nombre in "${nombres[@]}"; do
    echo "Hola, $nombre"
done

# Ejemplo 3: Iterar sobre los archivos en un directorio
echo "Archivos en el directorio actual:"
for archivo in *; do
    echo "$archivo"
done

# Ejemplo 1: Iterar sobre una secuencia definida
for i in {1..5}; do
    echo "Número: $i"
done

# Ejemplo 2: Iterar sobre una secuencia de caracteres
echo "Alfabeto:"
for letra in {a..z}; do
    echo "$letra"
done

# Ejemplo 3: Iterar sobre una secuencia con paso definido
echo "Contando de 0 a 10 de 2 en 2:"
for ((i=0; i<=10; i+=2)); do
    echo "$i"
done

# Ejemplo de estructura condicional if-else:
# Se utiliza para tomar decisiones basadas en condiciones.

echo "Estructura Condicional If-Else:"

# Ejemplo 1: Comprobando si un archivo existe
archivo="archivo.txt"
if [ -e "$archivo" ]; then
    echo "El archivo $archivo existe."
else
    echo "El archivo $archivo no existe."
fi

# Ejemplo 2: Comprobando el valor de una variable
numero=10
if [ $numero -gt 0 ]; then
    echo "El número es positivo."
elif [ $numero -eq 0 ]; then
    echo "El número es cero."
else
    echo "El número es negativo."
fi

# Ejemplo 3: Comprobando si un directorio está vacío
directorio="mi_directorio"
if [ -z "$(ls -A $directorio)" ]; then
    echo "El directorio $directorio está vacío."
else
    echo "El directorio $directorio no está vacío."
fi

echo

# Ejemplo de uso de operadores lógicos:
echo "Operadores Lógicos:"

# Ejemplo 1: AND lógico (&&)
edad=25
if [ $edad -gt 18 ] && [ $edad -lt 30 ]; then
    echo "La persona tiene entre 18 y 30 años."
fi

# Ejemplo 2: OR lógico (||)
usuario="admin"
if [ "$usuario" == "admin" ] || [ "$usuario" == "root" ]; then
    echo "El usuario tiene privilegios de administrador."
fi

echo

# Ejemplo de estructura condicional dentro de un bucle:
echo "Estructura Condicional Dentro de un Bucle:"

for i in {1..5}; do
    if [ $i -eq 3 ]; then
        echo "Saltando la iteración $i."
        continue
    fi
    echo "Iteración: $i"
done


exit 0
