@echo off

rem Comprobaciones con if

rem Comprobar si una variable es igual a un valor determinado
numero = 12

if numero == 12
    echo "El número es igual a 12"

rem Comprobar si una variable es mayor que un valor determinado
numero = 13

if numero > 12
    echo "El número es mayor que 12"

rem Comprobar si una variable es menor que un valor determinado
numero = 11

if numero < 12
    echo "El número es menor que 12"

rem Comprobación de si una variable es un número o una letra

rem Comprobar si una variable es un número
numero = "1234"

if "%numero%" == [0-9]+
    echo "La variable es un número"

rem Comprobar si una variable es una letra
letra = "a"

if "%letra%" == [a-zA-Z]+
    echo "La variable es una letra"

rem Solicitud de argumentos y por pantalla

rem Solicitar argumentos
set /p numero=Introduce un número:

rem Mostrar el número introducido
echo El número que has introducido es: %numero%

rem Solicitar un valor por pantalla
echo Introduce un valor:
set numero=<stdin

rem Mostrar el valor introducido
echo El valor que has introducido es: %numero%
