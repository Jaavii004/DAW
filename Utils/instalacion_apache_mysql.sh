#!/bin/bash

# Actualizar el sistema
sudo apt-get update
sudo apt-get upgrade -y

# Instalar Apache
sudo apt-get install apache2 -y

# Instalar PHP
sudo apt-get install php libapache2-mod-php php-mysql -y

# Reiniciar Apache para aplicar cambios
sudo systemctl restart apache2

# Instalar MySQL
sudo apt-get install mysql-server -y

# Configurar MySQL (sustituir 'tu_password' por una contraseña segura)
sudo mysql_secure_installation <<EOF

y
root
root
y
y
y
y
EOF

# Crear estructura de carpetas
sudo mkdir /var/www/sitios_web
sudo chown -R $USER:$USER /var/www/sitios_web

# Crear ejemplo de sitio web
echo "<?php phpinfo(); ?>" > /var/www/sitios_web/ejemplo/index.php

# Configurar Apache para el sitio de ejemplo
sudo tee /etc/apache2/sites-available/ejemplo.conf <<EOF
<VirtualHost *:80>
    DocumentRoot /var/www/sitios_web/ejemplo
    ServerName ejemplo.local
</VirtualHost>
EOF

sudo a2ensite ejemplo.conf
sudo systemctl restart apache2

# Añadir entrada al archivo hosts
echo "127.0.0.1 ejemplo.local" | sudo tee -a /etc/hosts

echo "Instalación completa. Accede a tu sitio web de ejemplo en http://ejemplo.local"
