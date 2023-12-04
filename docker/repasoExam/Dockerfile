# Imagen base que descargamos
FROM ubuntu:20.04

#Ejecuta comandos dentro del contenedor
RUN apt update; apt install -y tmux vim zip

#Direcctorio de trabajo 
WORKDIR /repo

#Exponer puertos Local:contenedor
EXPOSE 3306:33006 4443:443 8080:80


#COPY copia el archivo pero no descomprimira en caso de no existir la ruta la crea
#Copia y descomprime en destino en caso de no existir la ruta la crea
ADD repaso.zip /root/repaso

#Ejecutaq comandos fuera del contenedor pero contra el contenedor
CMD [ "/bin/bash" ]


# para crear la imagen  $ docker build -t repasoimage .
# para crear el contenedor $ docker run -it --name repasocont repasoimage
