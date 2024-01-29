#!/bin/bash

# Configura tu información de Duck DNS
DUCKDNS_DOMAIN="tudominio.duckdns.org"
DUCKDNS_TOKEN="tutoken"

# Obtiene la IP pública actual
current_ip=$(curl -s https://api64.ipify.org?format=json | jq -r .ip)

# Obtiene la IP registrada en Duck DNS
duckdns_ip=$(curl -s "https://www.duckdns.org/update?domains=$DUCKDNS_DOMAIN&token=$DUCKDNS_TOKEN&ip=")

# Compara las IPs
if [ "$current_ip" != "$duckdns_ip" ]; then
    # Actualiza la IP en Duck DNS
    update_result=$(curl -s "https://www.duckdns.org/update?domains=$DUCKDNS_DOMAIN&token=$DUCKDNS_TOKEN&ip=$current_ip")
    
    # Verifica si la actualización fue exitosa
    if [[ $update_result == "OK" ]]; then
        echo "IP actualizada correctamente en Duck DNS"
    else
        echo "Error al actualizar la IP en Duck DNS"
    fi
else
    echo "La IP no ha cambiado. No es necesario actualizar Duck DNS."
fi
