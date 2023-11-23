@echo off

:menu
cls
echo Menú de la calculadora
echo.
echo 1. Suma
echo 2. Resta
echo 3. Multiplicación
echo 4. División
echo 5. Salir
echo.

set /p opcion=Seleccione una opción: 

if "%opcion%"=="1" goto suma
if "%opcion%"=="2" goto resta
if "%opcion%"=="3" goto multiplicacion
if "%opcion%"=="4" goto division
if "%opcion%"=="5" goto salir

echo Opción inválida. Por favor, seleccione una opción válida.
pause
goto menu

:suma
REM BEGIN: Suma
echo.
set /p num1=Ingrese el primer número: 
set /p num2=Ingrese el segundo número: 

set /a resultado=%num1% + %num2%
echo El resultado de la suma es: %resultado%
pause
goto menu
REM END: Suma

:resta
REM BEGIN: Resta
echo.
set /p num1=Ingrese el primer número: 
set /p num2=Ingrese el segundo número: 

set /a resultado=%num1% - %num2%
echo El resultado de la resta es: %resultado%
pause
goto menu
REM END: Resta

:multiplicacion
REM BEGIN: Multiplicación
echo.
set /p num1=Ingrese el primer número: 
set /p num2=Ingrese el segundo número: 

set /a resultado=%num1% * %num2%
echo El resultado de la multiplicación es: %resultado%
pause
goto menu
REM END: Multiplicación

:division
REM BEGIN: División
echo.
set /p num1=Ingrese el primer número: 
set /p num2=Ingrese el segundo número: 

set /a resultado=%num1% / %num2%
echo El resultado de la división es: %resultado%
pause
goto menu
REM END: División

:salir
exit
