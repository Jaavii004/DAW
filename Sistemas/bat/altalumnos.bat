@echo off
setlocal

REM BEGIN: Validación de datos
set /p nombre="Introduce el nombre: "
set /p apellido="Introduce el apellido: "
set /p NIA="Introduce el NIA: "

REM Validar que los datos no estén vacíos
if "%nombre%"=="" (
    echo Error: El nombre no puede estar vacío.
    exit /b 1
)
if "%apellido%"=="" (
    echo Error: El apellido no puede estar vacío.
    exit /b 1
)
if "%NIA%"=="" (
    echo Error: El NIA no puede estar vacío.
    exit /b 1
)
REM END: Validación de datos

REM Crear el archivo alumnos.csv
echo nombre,apellido,NIA > alumnos.csv
echo %nombre%,%apellido%,%NIA% >> alumnos.csv

echo El archivo alumnos.csv ha sido creado exitosamente.
