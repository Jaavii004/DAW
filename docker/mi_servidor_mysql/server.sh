#!/bin/bash

# Definir la contraseña que se usará para el usuario root
MYSQL_ROOT_PASSWORD="tu_contraseña"

# Instalar MySQL Server sin solicitar la contraseña durante la instalación
export DEBIAN_FRONTEND=noninteractive
sudo debconf-set-selections <<< "mysql-server mysql-server/root_password password $MYSQL_ROOT_PASSWORD"
sudo debconf-set-selections <<< "mysql-server mysql-server/root_password_again password $MYSQL_ROOT_PASSWORD"

# Instalar MySQL Server
sudo apt-get update
sudo apt-get install -y mysql-server

# Reiniciar el servicio MySQL para aplicar la configuración
sudo systemctl restart mysql

# Imprimir mensaje de finalización
echo "MySQL instalado y configurado con la contraseña root: $MYSQL_ROOT_PASSWORD"
