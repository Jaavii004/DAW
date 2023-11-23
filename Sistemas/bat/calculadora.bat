@echo off


:menu
title calculadora
cls
echo Menu de la calculadora
color 9
echo.
echo 1. Suma
echo 2. Resta
echo 3. Multiplicacion
echo 4. Division
echo 5. Salir
echo.

set /p opcion=Pon un numero: 

if "%opcion%"=="1" goto suma
if "%opcion%"=="2" goto resta
if "%opcion%"=="3" goto multiplicacion
if "%opcion%"=="4" goto division
if "%opcion%"=="5" goto salir

echo error pon un numero.
pause > null
goto menu

:suma
REM BEGIN: Suma
echo.
set /p num1=primer numero: 
set /p num2=segundo numero: 

set /a resultado=%num1% + %num2%
cls
echo El resultado de la suma es: %resultado%
pause
goto menu

:resta
REM BEGIN: Resta
echo.
set /p num1=primer numero: 
set /p num2=segundo numero:

set /a resultado=%num1% - %num2%
cls
echo El resultado de la resta es: %resultado%
pause
goto menu

:multiplicacion
REM BEGIN: Multiplicación
echo.
set /p num1=primer numero: 
set /p num2=segundo numero:

set /a resultado=%num1% * %num2%
cls
echo El resultado de la multiplicación es: %resultado%
pause
goto menu

:division
REM BEGIN: División
echo.
set /p num1=primer numero: 
set /p num2=segundo numero: 
if "%num2%"=="0" ( 
    echo numero no valido
) else (


    set /a resultado=%num1% / %num2%
    cls
    echo El resultado de la división es: %resultado%
)
pause
goto menu

:salir
exit
