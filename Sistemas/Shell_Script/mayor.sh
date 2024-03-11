#!/bin/bash

max=0

for num in "$@"; do
    if ((num > max)); then
        max=$num
    fi
done

# Mostrar el número más grande
echo "El número más grande es: $max"

exit 0