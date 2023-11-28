@echo off
REM BEGIN: Contar líneas de un archivo

REM Cambiar la codificación de la consola a UTF-8
chcp 65001 > nul

REM Limpiar la consola
cls

REM BEGIN: Contar líneas de un archivo
if "%1"=="" (
    echo Error: Debes especificar un archivo.
    REM Salir del script con código de error 1
    exit /b 1
)

REM Validar que el archivo exista
if not exist "%1" (
    echo Error: El archivo %1 no existe.
    REM Salir del script con código de error 1
    exit /b 1
)

REM Asignar el nombre del archivo a una variable
set "file=%1"
REM Asignar el valor 0 a la variable count
set /a count=0
REM Contar líneas
for /f %%a in (%file%) do (
    set /a count=1+count
)
REM Mostrar el resultado
echo El archivo %file% tiene %count% líneas.

REM Salir del script con código de error 0
exit /b 0

REM END: Contar líneas de un archivo
pause
