#!/bin/bash

# Función para imprimir la interfaz del programa
print_interface() {
    clear
    echo "============================="
    echo "      MENSAJERÍA LOCAL       "
    echo "============================="
    echo
    echo "Ingrese el mensaje a enviar:"
    echo "Presione ENTER para enviar el mensaje"
    echo "Ingrese 'exit' para salir del programa"
    echo
}

# Función para enviar el mensaje a los destinos especificados
send_message() {
    local message="$1"
    local port=12345
    local destinations=("192.168.5.9" "192.168.5.7")

    for dest in "${destinations[@]}"; do
        echo "Enviando mensaje a $dest..."
        echo "$message" | socat - UDP-DATAGRAM:$dest:$port
    done
}

# Loop principal del programa
while true; do
    print_interface

    read -p "Mensaje: " message

    # Salir si se ingresa "exit"
    if [ "$message" == "exit" ]; then
        break
    fi

    # Enviar el mensaje a las direcciones IP especificadas
    send_message "$message" 

    read -p "Presione ENTER para continuar..."
done

echo "Saliendo del programa. ¡Adiós!"
