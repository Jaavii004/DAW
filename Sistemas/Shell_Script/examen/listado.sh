#!/bin/bash

read -p "Cuantos quieres premiar? " premio

cat alumnos.csv | sort -t ';' -k6 -n > tmp.txt

# MATRICULA;NOMBRE;APELLIDO;CICLO;CURSO;NOTA;POBLACION
# Lo pongo a -1 porque empiezo sumando arriba
cont=-1

# Compruebo si esta el archivo de salida
if [ -f FP_2023_2024.txt ];then
    rm FP_2023_2024.txt
else
    touch FP_2023_2024.txt
fi
# Itera sobre cada línea del archivo
while IFS=';' read MATRICULA NOMBRE APELLIDO CICLO CURSO NOTA POBLACION; do 
    # no me quedo con la  linea que tenga MATRICULA
    if [ $MATRICULA != "MATRICULA" ] ; then 
        ((cont ++))
        comp=0
        # cuento cuantos alumnos hay con la misma nota si hay uno lo añado si hay mas ordeno por apellidos
        comp=$(cat tmp.txt | cut -d ";" -f2,3,4,6  | grep -c $NOTA)
        if [ 1 -le $comp ] ; then
            echo $NOMBRE" "$APELLIDO" "$CICLO >> FP_2023_2024.txt
            #echo $MATRICULA $NOMBRE $APELLIDO $CICLO $CURSO $NOTA $POBLACION
        else
            cat tmp.txt | cut -d ";" -f2,3,4,6  | grep $NOTA | tr ";" " " | cut -f2,3,4 | sort -t ' ' -k2 -k1 > tmp_$NOTA.txt
            while IFS=';' read NOMBRE APELLIDO CICLO n; do
                ((cont ++))
                echo $NOMBRE" "$APELLIDO" "$CICLO >> FP_2023_2024.txt
                if [ $cont -eq $premio ]; then
                    rm tmp_$NOTA.txt 2>/dev/null
                    break
                fi
            done  < tmp_$NOTA.txt
        fi
        if [ $cont -gt $premio ]; then
            break
        fi
    fi
done < tmp.txt


cat FP_2023_2024.txt | sort -t ' ' -k2 -k1 > tmp_ord.txt
cat tmp_ord.txt > FP_2023_2024.txt
rm tmp*.txt
echo "Añadidos a FP_2023_2024.txt"

exit 0