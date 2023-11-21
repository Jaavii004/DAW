@echo off
setlocal enabledelayedexpansion

REM Preguntar por los límites del rango
set /p "min=Ingresa el número mínimo del rango: "
set /p "max=Ingresa el número máximo del rango: "

REM Generar número aleatorio y mostrarlo
set /a range=max-min+1
set /a random=%random% %% range + min

echo El número aleatorio entre %min% y %max% es: %random%

pause
