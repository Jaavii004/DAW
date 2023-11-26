@echo off
cls

REM Preguntar al usuario
set /p nombre="Ingresa tu nombre: "
echo Hola, %nombre%!

REM Utilizar if para comparar valores
set /p edad="Ingresa tu edad: "
if %edad% lss 18 (
    echo Eres menor de edad.
) else (
    echo Eres mayor de edad.
)

REM Leer argumentos de la línea de comandos
if "%1"=="" (
    echo No se proporcionaron argumentos.
) else (
    echo El primer argumento es: %1
)

REM Más ejemplos de condiciones if
set /p opcion="Elige una opción (1 o 2): "
if %opcion% equ 1 (
    echo Elegiste la opción 1.
) else if %opcion% equ 2 (
    echo Elegiste la opción 2.
) else (
    echo Opción no válida.
)

pause
