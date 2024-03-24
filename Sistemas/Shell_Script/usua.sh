#!/bin/bash

# Verificar si se es superusuario
if [ "$(id -u)" -ne 0 ]; then
    echo "Este script debe ejecutarse como root" 1>&2
    exit 1
fi

# Solicitar datos del nuevo usuario
read -p "Nombre de usuario: " username
read -s -p "Contraseña: " password
echo

# Generar la entrada para /etc/passwd
user_entry="$username:x:1001:1001::/home/$username:/bin/bash"

# Agregar la entrada al archivo /etc/passwd
echo "$user_entry" >> /etc/passwd

# Establecer la contraseña del usuario
echo "$username:$password" | chpasswd

echo "Usuario $username añadido correctamente."
