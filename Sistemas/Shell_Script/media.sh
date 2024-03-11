#!/bin/bash
clear
suma=0

for arg in "$@"; do
    suma=$(($suma+$arg))
done

echo "Los argumentos pasados son: "$(echo $@| tr " " ", ")"."
echo "La media de los argumentos pasados es de: "$(($suma/$#))

exit 0