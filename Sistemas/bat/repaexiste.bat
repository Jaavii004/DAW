@echo off

title Media

set /p "ruta=ruta existe "

if exist %ruta% (
    echo Existe %ruta%
) else (
    echo No existe %ruta%
)
