# Instalar apache2 en Ubuntu 24.04


## Antes de todo debemos cambiar la direccion IP
Lo vamos a hacer con netplan

vamos a ir a la ruta **sudo nano /etc/netplan/50-cloud-init.yaml** y pondremos lo siguiente:


```bash
# This file is generated from information provided by the datasource.  Changes
# to it will not persist across an instance reboot.  To disable cloud-init's
# network configuration capabilities, write a file
# /etc/cloud/cloud.cfg.d/99-disable-network-config.cfg with the following:
# network: {config: disabled}
#network:
#    ethernets:
#        enp0s3:
#            dhcp4: true
#    version: 2
network:
  version: 2
  ethernets:
    enp0s3:
      addresses:
        - 192.168.5.58/23
      routes:
        - to: default
          via: 192.168.4.254
      nameservers:
          addresses: [8.8.8.8, 4.4.4.4]
```

cuando lo tengamos tendremos que ejecutar para que se aplique la configuracion **sudo netplan apply**


### Empezamos a instalar apache2
Vamos a empezar a instalar apache2.

Lo primero que hacemos es traernos los paquetes nuevos.
```bash
sudo apt update
```

Y despues instalaremos el servidor apache2.
```bash
sudo apt install apache2
```

## Crear los VirtualHosts


Crear las dos carpetas en /WEB

mkdir docs
mkdir personal

Ahora vamos a crear los virtualHosts

en este archivo **/etc/apache2/sites-available/personal.conf** creamos el archivo y ponemos este comando **sudo a2ensite personal.conf**
```bash                            
<VirtualHost *:80>
    # The ServerName directive sets the request scheme, hostname and port that
    # the server uses to identify itself. This is used when creating
    # redirection URLs. In the context of virtual hosts, the ServerName
    # specifies what hostname must appear in the request's Host: header to
    # match this virtual host. For the default virtual host (this file) this
    # value is not decisive as it is used as a last resort host regardless.
    # However, you must set it for any further virtual host explicitly.
    ServerName www.javier.test
    DocumentRoot /WEB/personal/

    # Available loglevels: trace8, ..., trace1, debug, info, notice, warn,
    # error, crit, alert, emerg.
    # It is also possible to configure the loglevel for particular
    # modules, e.g.
    #LogLevel info ssl:warn

    ErrorLog ${APACHE_LOG_DIR}/error-personal.log
    CustomLog ${APACHE_LOG_DIR}/access-personal.log combined

    <Directory "/WEB/personal">
        Allow from all
        Order allow,deny
        Require all granted
    </Directory>
    # For most configuration files from conf-available/, which are
    # enabled or disabled at a global level, it is possible to
    # include a line for only one particular virtual host. For example the
    # following line enables the CGI configuration for this host only
    # after it has been globally disabled with "a2disconf".
    #Include conf-available/serve-cgi-bin.conf
</VirtualHost>


```

Crear el otro virtualHost
en este archivo /etc/apache2/sites-available/docs.conf creamos el archivo y ponemos este comando **sudo a2ensite docs.conf**
```bash                               
<VirtualHost *:80>
    # The ServerName directive sets the request scheme, hostname and port that
    # the server uses to identify itself. This is used when creating
    # redirection URLs. In the context of virtual hosts, the ServerName
    # specifies what hostname must appear in the request's Host: header to
    # match this virtual host. For the default virtual host (this file) this
    # value is not decisive as it is used as a last resort host regardless.
    # However, you must set it for any further virtual host explicitly.
    ServerName www.docs.javier.test

    DocumentRoot /WEB/docs/

    # Available loglevels: trace8, ..., trace1, debug, info, notice, warn,
    # error, crit, alert, emerg.
    # It is also possible to configure the loglevel for particular
    # modules, e.g.
    #LogLevel info ssl:warn

    ErrorLog ${APACHE_LOG_DIR}/error-docs.log
    CustomLog ${APACHE_LOG_DIR}/access-docs.log combined
    <Directory "/WEB/docs/">
        Order allow,deny
        Allow from all
        Require all granted
    </Directory>

    # For most configuration files from conf-available/, which are
    # enabled or disabled at a global level, it is possible to
    # include a line for only one particular virtual host. For example the
    # following line enables the CGI configuration for this host only
    # after it has been globally disabled with "a2disconf".
    #Include conf-available/serve-cgi-bin.conf
</VirtualHost>

```



Reiniciaremos el server de apache con 
sudo service apache2 restart
