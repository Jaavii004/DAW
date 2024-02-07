#!/bin/bash

# Encabezado de la respuesta HTTP
echo "Content-type: text/html"
echo ""

# HTML de la página
echo "<!DOCTYPE html>"
echo "<html lang='es'>"
echo "<head>"
echo "<meta charset='UTF-8'>"
echo "<title>Terminal Web</title>"
echo "<style>"
echo "body { font-family: monospace; background-color: #000; color: #fff; margin: 0; padding: 0; }"
echo ".terminal { width: 100%; height: 100vh; overflow: hidden; }"
echo ".output { overflow-y: scroll; height: 80%; padding: 10px; border-bottom: 2px solid #fff; }"
echo ".input { width: calc(100% - 20px); padding: 10px; border: none; background-color: transparent; color: #fff; }"
echo ".input:focus { outline: none; }"
echo ".input-container { padding: 10px; }"
echo "</style>"
echo "</head>"
echo "<body>"

# Div contenedor de la terminal
echo "<div class='terminal'>"

# Div para la salida de los comandos
echo "<div class='output' id='output'></div>"

# Formulario para ingresar comandos
echo "<div class='input-container'>"
echo "<form method='post' onsubmit='scrollToBottom()'>"
echo "<input type='text' class='input' name='command' placeholder='Ingrese un comando' autofocus>"
echo "</form>"
echo "</div>"

# Procesamiento del formulario
if [ "$REQUEST_METHOD" = "POST" ]; then
    # Leer el comando ingresado por el usuario
    read -r command
    # Ejecutar el comando y mostrar el resultado
    echo "<pre>"
    eval "$command"
    echo "</pre>"
fi

echo "</div>"

# Script para desplazarse automáticamente hacia abajo
echo "<script>"
echo "function scrollToBottom() {"
echo "  var element = document.getElementById('output');"
echo "  element.scrollTop = element.scrollHeight;"
echo "}"
echo "scrollToBottom();"
echo "</script>"

echo "</body>"
echo "</html>"
