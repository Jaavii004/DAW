#!/bin/bash

function logInfo() {
    START='\033[01;32m'
    END='\033[00;00m'
    MESSAGE=${@:-""}
    echo -e "${START}${MESSAGE}${END}"
}

who | while read line; do
    usu=$(echo $line | awk $'{print $1}')
    tty=$(echo $line | awk $'{print $2}')
    dia=$(echo $line | awk $'{print $3 ,$4}')
    echo -e "El usuario \033[01;32m"$usu"\033[00;00m esta registrado en la \033[01;32m"$tty" \033[00;00my esta logueado desde las \033[01;32m"$dia"\033[00;00m."

    echo
    echo "Usuario: "$(logInfo $usu)
    echo "Donde: "$(logInfo $tty)
    echo "Dia y Hora: "$(logInfo $dia)
    echo
done

exit 0
