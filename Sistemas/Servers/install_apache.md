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


### Empezamos a instalar 
Vamos a empezar a instalar apache2.

Lo primero que hacemos es traernos los cambios 

```bash
sudo apt update
```


```bash
sudo apt install apache2
```
