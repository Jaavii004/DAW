#!/bin/bash

# Actualizar la lista de paquetes
sudo apt update

# Instalar MySQL Server
sudo apt install mysql-server

# Asegurar el servicio MySQL
sudo systemctl enable mysql

# Iniciar el servicio MySQL
sudo systemctl start mysql

# Establecer contraseña para el usuario root de MySQL
sudo mysql_secure_installation

# Crear un usuario de MySQL con privilegios
echo "CREATE USER 'javier'@'localhost' IDENTIFIED BY 'root';" | sudo mysql -u root -p
echo "GRANT ALL PRIVILEGES ON *.* TO 'javier'@'localhost' WITH GRANT OPTION;" | sudo mysql -u root -p
echo "FLUSH PRIVILEGES;" | sudo mysql -u root -p

# Mostrar información de conexión
echo "**Información de conexión:**"
echo "Usuario root: root"
echo "Contraseña root: (la que configuraste en el script)"
echo "Usuario con privilegios: javier"
echo "Contraseña del usuario: root"

echo "**Conectarse a MySQL:**"
echo "mysql -u root -p"

echo "¡MySQL Server instalado y configurado!"