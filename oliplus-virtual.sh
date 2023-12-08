#!/bin/bash

print-not-found(){
    ping -w 2 -c 1 8.8.8.81 > /dev/null
    if [ $? -eq 0 ]; then
        echo "Tienes internet"
    else
        zenity --width 250 --info --text "Parece que no tenemos conexion a internet.Comprueba el cable y vuelve a intentarlo"
    fi
}

clean_firefox(){
    zenity --info --text "Su firefox se cerrará"
    killall firefox || true
    rm -rf $HOME/.mozilla
}

shut-down(){
    zenity --info --text "El equipo se apagará"
    shutdown -h now
}

display-rare(){
    xfce4-display-settings
}

ans=$(zenity  --title "Oliplus Virtual" --width 800 --height 600 --list  --text "En que te puedo ayudar?" --radiolist  --column "Elija una" --column "Acción" TRUE "Mando a la impresora y no imprime" FALSE "Las pantallas se ven raro" FALSE "No me va bien el Firefox" FALSE "Instalar impresora PryntControl" FALSE "No puedo apagar el equipo")
case "$ans" in
    "Mando a la impresora y no imprime")
        print-not-found
    ;;
    "Las pantallas se ven raro")
        display-rare
    ;;
    "Limpia el Firefox")
        clean_firefox
    ;;
    "Apaga el Equipo")
        shut-down
    ;;
    *)
        echo "Desconocido"
    ;;
esac

zenity --width 250 --height 100 --info --text="Gracias por utilizar el Oliplus Virtual"

exit 0

id=$(id -u)

if [ "$id" -ne 0 ]; then
    PASSWORD=$(zenity --password --title="Contraseña ROOT: " --timeout=20)
    if [ $? -eq 1 ]; then
        zenity --info --text "Operación cancelada." --timeout=20
        exit 1
    fi

    echo "$PASSWORD" | sudo -S "$0"
    exit $?
fi
