FROM php:8.0-apache

RUN apt update && apt install -y tmux vim zip

WORKDIR /code

EXPOSE 4443:443 8080:80

ADD examen.zip /root/examen

CMD /bin/bash