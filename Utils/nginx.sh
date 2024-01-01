#!/bin/bash

# Detener el servicio de Apache
sudo systemctl stop apache2

# Deshabilitar el servicio de Apache para que no se inicie en el arranque
sudo systemctl disable apache2

# Desinstalar Apache
sudo apt-get purge apache2 apache2-utils -y
sudo apt-get autoremove -y

# Eliminar archivos de configuración de Apache
sudo rm -rf /etc/apache2


echo "Apache ha sido desinstalado correctamente."
