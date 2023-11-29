@echo off

title Media

set /p "nombre=Dime tu nombre"

set /p "edad=Dime tu edad %nombre%"

set /p "nombre2=Dime otro nombre"

set /p "edad2=Dime de %nombre2%"

set /a media=(edad+edad2)/2

echo %media%
