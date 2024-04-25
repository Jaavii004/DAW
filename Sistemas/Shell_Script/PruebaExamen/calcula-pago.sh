#!/bin/bash

meses=("ENERO" "FEBRERO" "MARZO" "ABRIL" "MAYO" "JUNIO" "JULIO" "AGOSTO" "SEPTIEMBRE" "OCTUBRE" "NOVIEMBRE" "DICIEMBRE")

mes=$(date +"%m")

mesescri=${meses[$mes-1]}

if [ -f pagar-$mesescri.txt ]; then
    rm pagar-$mesescri.txt
fi

while IFS="," read -r AUTOR TITULO PALABRAS; do
    echo $AUTOR", 1 articulo, "$PALABRAS" palabras, "$(echo "$PALABRAS * 0.10" | bc)"€" >> pagar-$mesescri.txt
done < palabras-$mesescri.txt

exit 0