#!/bin/bash


while IFS=':' read NOMBRE a id_usu c d homeusu d ; do
    ((cont ++))
    if [ $id_usu -ge 1000 ]; then
        if [ $homeusu != "/nonexistent" ]; then
            if [ -d $homeusu ]; then
                su - $NOMBRE -p 
            else
                echo "No"$homeusu
            fi
        fi
    fi
done  < /etc/passwd






exit 0