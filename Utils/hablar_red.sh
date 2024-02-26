#!/bin/bash

message="$1"
port=12345
destinations=("192.168.5.9" "192.168.5.7")

for dest in "${destinations[@]}"; do
    echo "$message" | socat - UDP-DATAGRAM:$dest:$port
done

exit 0

## Para escuchar ese mensaje tienes que estar ejecutando el comando
## Tiene que estar ejecutandose antes de mandarlo desde aqui
# socat - UDP-RECV:12345