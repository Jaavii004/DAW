@echo off
chcp 65001 > null

title adivina

set /p "min=mín: "
set /p "max=max: "

set /a random=%random% %% (max-min+1) + min

:pregunta
set /p "num=Numero: "

:igual
if %num% == %random% goto victoria else goto error

:error
echo El número aleatorio no es correcto. Sigue jugando
goto pregunta

:victoria
echo El número aleatorio entre %min% y %max% es: %random% Enhorabuena
