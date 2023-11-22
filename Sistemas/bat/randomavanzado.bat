@echo off
cls
chcp 65001 > nul

set /p maximo="Escribe el numero máximo: "
set /p minimo="Escribe el numero mínimo: "

if %maximo% GTR %minimo% (
    set /A RAND=%RANDOM% * (%maximo% - %minimo% +1) / 32768 + %minimo%
    echo El numero random es %RAND%
) else (
    echo "error: maximo no es mayor que minimo
)