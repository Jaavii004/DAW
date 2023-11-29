@echo off
set /p origen=Ingrese la ruta del archivo de origen:
set /p destino=Ingrese la ruta del directorio de destino:
copy %origen% %destino%
echo Archivo copiado a %destino%
pause
