#!/bin/bash

# Configurar el módulo ngx_http_stub_status_module en Nginx
echo "location /nginx_status {
    stub_status on;
    allow 127.0.0.1;
    deny all;
}" | sudo tee /etc/nginx/sites-available/nginx_status

sudo ln -s /etc/nginx/sites-available/nginx_status /etc/nginx/sites-enabled/

# Reiniciar Nginx para aplicar los cambios
sudo service nginx restart

# URL de la página de estadísticas
NGINX_STATUS_URL="http://localhost/nginx_status"

# Verifica si el comando 'xdg-open' está disponible (Linux)
if command -v xdg-open &> /dev/null; then
    xdg-open "$NGINX_STATUS_URL"
# Verifica si el comando 'open' está disponible (macOS)
elif command -v open &> /dev/null; then
    open "$NGINX_STATUS_URL"
# Intenta abrir en el navegador predeterminado en otros sistemas
else
    sensible-browser "$NGINX_STATUS_URL" || x-www-browser "$NGINX_STATUS_URL" || gnome-open "$NGINX_STATUS_URL" || kde-open "$NGINX_STATUS_URL"
fi
