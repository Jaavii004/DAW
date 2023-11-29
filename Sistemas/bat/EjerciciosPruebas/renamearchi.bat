@echo off
set /p archivo=Ingrese la ruta del archivo a renombrar:
set /p nuevoNombre=Ingrese el nuevo nombre:
ren %archivo% %nuevoNombre%
echo Archivo renombrado a %nuevoNombre%
pause
