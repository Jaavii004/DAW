#!/bin/bash

# Actualizar el sistema
sudo apt-get update
sudo apt-get upgrade -y

# Instalar Nginx y PHP-FPM
sudo apt-get install nginx php-fpm -y

# Instalar phpMyAdmin
sudo apt-get install phpmyadmin -y

# Configurar phpMyAdmin para Nginx
sudo tee /etc/nginx/sites-available/phpmyadmin <<EOF
server {
    listen 80;
    server_name phpmyadmin.local; # Cambia esto según tu configuración

    root /usr/share/phpmyadmin;
    index index.php index.html index.htm;

    location / {
        try_files $uri $uri/ =404;
    }

    location ~ \.php$ {
        include snippets/fastcgi-php.conf;
        fastcgi_pass unix:/var/run/php/php7.4-fpm.sock; # Asegúrate de cambiar la versión de PHP según tu instalación
        fastcgi_param SCRIPT_FILENAME $document_root$fastcgi_script_name;
        include fastcgi_params;
    }

    location ~ /\.ht {
        deny all;
    }
}
EOF

# Crear enlace simbólico y reiniciar Nginx
sudo ln -s /etc/nginx/sites-available/phpmyadmin /etc/nginx/sites-enabled/
sudo systemctl restart nginx

# Modificar el archivo de hosts
echo "127.0.0.1 phpmyadmin.local" | sudo tee -a /etc/hosts

echo "Instalación completa. Accede a phpMyAdmin en http://phpmyadmin.local"
