#!/bin/bash

# Actualizar los repositorios e instalar MySQL Server y phpMyAdmin
sudo apt-get update
sudo DEBIAN_FRONTEND=noninteractive apt-get install -y mysql-server phpmyadmin

# Configurar MySQL Server
sudo mysql_secure_installation

# Habilitar la extensión de MySQLi en PHP (necesario para phpMyAdmin)
sudo phpenmod mysqli
sudo systemctl restart apache2

# Configurar phpMyAdmin
sudo ln -s /etc/phpmyadmin/apache.conf /etc/apache2/conf-available/phpmyadmin.conf
sudo a2enconf phpmyadmin.conf
sudo systemctl restart apache2

echo "Servidor MySQL y phpMyAdmin instalados y configurados."
echo "Accede a phpMyAdmin desde tu navegador: http://localhost/phpmyadmin"
