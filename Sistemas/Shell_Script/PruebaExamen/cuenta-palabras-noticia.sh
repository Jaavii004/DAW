#!/bin/bash

if [ "$#" -ne 1 ]; then
    echo "Uso: *$0* Nombre_archivo_noticia"
    exit 1
fi

archivo=$1

meses=("ENERO" "FEBRERO" "MARZO" "ABRIL" "MAYO" "JUNIO" "JULIO" "AGOSTO" "SEPTIEMBRE" "OCTUBRE" "NOVIEMBRE" "DICIEMBRE")

while IFS="$" read -r ID FECHA TITULO AUTOR TEXTO; do
    mes=$(date -d "$FECHA" +"%m")
    nombrearchi="palabras-"${meses[$mes-1]}".txt"
    contarpala=$(echo $TEXTO | wc -w)
    MAY=$(echo "$TITULO" | tr '[:lower:]' '[:upper:]')
    #MAY=$(echo "$TITULO" | tr 'a-z' 'A-Z')
    frase="$AUTOR, $MAY, $contarpala"
    if ! grep -q "$frase" "$nombrearchi" ; then
        echo "$frase" >> "$nombrearchi"
    fi
done < /NOTICIAS/$archivo

exit 0