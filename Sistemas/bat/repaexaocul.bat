
@echo off
title mostrar archivos ocultos usb
color 30
echo.
echo.
echo = mostrar archivo ocultos =
echo.
echo.
echo.
echo unidades soportadas e,f,g,h,i,j,k,l,m,n
echo
echo ingresa unidad usb luego enter
echo.
set /p drive=
echo %drive%

if %drive%== 1 goto 1
if %drive%== E goto E
if %drive%== F goto F
if %drive%== G goto G
if %drive%== H goto H
if %drive%== I goto I
if %drive%== J goto J
if %drive%== K goto K
if %drive%== L goto L
if %drive%== M goto M
if %drive%== N goto N
if %drive%== exit goto exit

if %drive%== e goto e
if %drive%== f goto f
if %drive%== g goto g
if %drive%== h goto h
if %drive%== i goto i
if %drive%== j goto j
if %drive%== k goto k
if %drive%== l goto l
if %drive%== m goto m
if %drive%== n goto n
if %drive%== EXIT goto EXIT
:E
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H E:/*.* /S /D
cls
echo completado
pause>nul
exit

:F
cls
Echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H F:/*.* /S /D
cls
echo completado
pause>nul
exit
:G
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H G:/*.* /S /D
cls
echo completado
pause>nul
exit
:H
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H H:/*.* /S /D
cls
echo completado
pause>nul
exit
:I
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H I:/*.* /S /D
cls
echo completado
pause>nul
exit
:J
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H J:/*.* /S /D
cls
echo completado
pause>nul
exit
:K
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H K:/*.* /S /D
cls
echo completado
pause>nul
exit
:L
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H L:/*.* /S /D
cls
echo completado
pause>nul
exit
:M
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H M:/*.* /S /D
cls
echo completado
pause>nul
exit
:N
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H N:/*.* /S /D
cls
echo completado
pause>nul
exit
:EXIT
exit
:e
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H E:/*.* /S /D
cls
echo completado
pause>nul
exit
:f
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H F:/*.* /S /D
cls
echo completado
pause>nul
exit
:g
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H G:/*.* /S /D
cls
echo completado
pause>nul
exit
:h
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H H:/*.* /S /D
cls
echo completado
pause>nul
exit
:i
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H I:/*.* /S /D
cls
echo completado
pause>nul
exit
:j
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H J:/*.* /S /D
cls
echo completado
pause>nul
exit
:k
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H K:/*.* /S /D
cls
echo completado
pause>nul
exit
:l
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H L:/*.* /S /D
cls
echo completado
pause>nul
exit
:m
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H M:/*.* /S /D
cls
echo completado
pause>nul
exit
:n
cls
echo espere un momento puede tardar dependiendo de la cantidad
@echo off
ATTRIB -R -A -S -H N:/*.* /S /D
cls
echo completado
pause>nul
exit
:exit
exit
