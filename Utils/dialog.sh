#!/bin/bash

# Función para enviar el mensaje a los destinos especificados
send_message() {
    local message="$1"
    local port=12345
    local destinations=("192.168.5.9" "192.168.5.7")

    for dest in "${destinations[@]}"; do
        echo "$message" | nc -u -w1 $dest $port
    done
}

# Función para ver los mensajes recibidos
view_messages() {
    local port=12345
    nc -ul $port
}

# Loop principal del programa
while true; do
    echo "============================="
    echo "      MENSAJERÍA LOCAL       "
    echo "============================="
    echo "1. Enviar mensaje"
    echo "2. Ver mensajes"
    echo "3. Salir"
    echo
    read -p "Seleccione una opción: " option

    case $option in
        1)
            read -p "Ingrese el mensaje: " message
            if [ -n "$message" ]; then
                send_message "$message"
                echo "Mensaje enviado correctamente."
            else
                echo "Debe ingresar un mensaje."
            fi
            ;;
        2)
            echo "Mensajes recibidos:"
            view_messages
            ;;
        3)
            break
            ;;
        *)
            echo "Opción inválida."
            ;;
    esac
done

echo "Saliendo del programa. ¡Adiós!"
