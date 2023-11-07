# Este archivo Dockerfile se utiliza para construir una imagen de Docker personalizada basada en Ubuntu.

# Se utiliza la última versión de Ubuntu como imagen base.
FROM ubuntu:latest

# Se actualiza el índice de paquetes y se instala el editor de texto nano.
RUN apt-get update && apt-get install nano -y

# Expone el puerto 80 del contenedor en el puerto 8080 del host
EXPOSE 8080:80

# Se establece el comando predeterminado para ejecutar el contenedor.
CMD /bin/bash