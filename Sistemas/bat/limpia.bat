@echo off
chcp 65001 > nul

title Limpia

set extension=%1%
REM Para ver si esta vacio o no
if not "%extension%"=="" (
    echo Eliminamos los archivos ".%extension%"
    del C:\Users\javie\Downloads\*.%extension%
) else (
    echo No has puesto ninguna extension No borramos nada estas a salvo
)
