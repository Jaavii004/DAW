@echo off
echo Bienvenido al programa de saludos!
echo.

echo Nombre de usuario: %USERNAME%
echo Nombre del ordenador: %COMPUTERNAME%
for /f "tokens=1-3 delims=:." %%a in ("%TIME%") do (
    set "hora=%%a"
    set "minutos=%%b"
    set "segundos=%%c"
)
echo Hora del sistema: %hora%:%minutos%
echo Fecha del sistema: %DATE%
