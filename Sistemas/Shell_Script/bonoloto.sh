#!/bin/bash

numeros=0
declare -a numbono

while [ $numeros -lt 6 ]; do
    bono=$((RANDOM % 49 + 1))
    encon=0
    for elem in "${numbono[@]}"; do
        if [ $elem -eq $bono ]; then
            encon=1
        fi
    done
    if [ $encon -eq 0 ]; then
        numbono+=("$bono")
        ((numeros ++))
    fi
done

ordenaos=$(echo "${numbono[@]}" | tr ' ' '\n' | sort -n | tr '\n' ' ')

for numero in "${ordenaos[@]}"; do
    echo -n $numero" "
done
echo

exit 0