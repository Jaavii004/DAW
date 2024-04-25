#!/bin/bash

meses=("ENERO" "FEBRERO" "MARZO" "ABRIL" "MAYO" "JUNIO" "JULIO" "AGOSTO" "SEPTIEMBRE" "OCTUBRE" "NOVIEMBRE" "DICIEMBRE")

for ((i=1; i <= 12; i++)); do
    nombrearchi="palabras-"${meses[$i-1]}".txt"
    if [ -f $nombrearchi ]; then
        rm $nombrearchi
    fi
    for archivo in /NOTICIAS/noticia*.txt; do
        while IFS="$" read -r ID FECHA TITULO AUTOR TEXTO; do
            mes=$(date -d "$FECHA" +"%m")
            if [ "$mes" -eq "$i" ]; then
                contarpala=$(echo $TEXTO | wc -w)
                MAY=$(echo "$TITULO" | tr '[:lower:]' '[:upper:]')
                echo $AUTOR", "$MAY", "$contarpala >> $nombrearchi
            fi
        done < $archivo
    done
done

exit 0