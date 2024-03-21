#!/bin/bash

# Compilar la clase
javac -cp ./lib/mysql-connector-j-8.3.0.jar $1

# Si no se produjo ningún error, ejecutar la clase
if [[ $? -eq 0 ]]; then
    # Ejecutar la clase
    cua=$(echo $1 | cut -d "." -f1)
    java -cp .:./lib/mysql-connector-j-8.3.0.jar $cua
fi