@echo off
set /p archivo=Ingrese la ruta del archivo a eliminar:
del %archivo%
echo Archivo eliminado: %archivo%
pause
