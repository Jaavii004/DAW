#Imagen base ubuntu
FROM ubuntu:latest
# Actualizamos lista de paquetes e instalamos nano (-y para no preguntar)
# Las últimas líneas son para hacer la imagen más ligera
RUN apt update && apt install -y nano && apt purge --auto-remove && apt clean && rm -rf /var/lib/apt/lists/*
# Establecemos como comando por defecto de la imagen /bin/bash
CMD /bin/bash