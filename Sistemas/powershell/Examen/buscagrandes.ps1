# Javier Puertas Rosello
# Primero pido es epacio que quieres buscar para mostrar los superiores
# Despues entramos en un bucle que busca por todas las unidades logicas del sistema
# y despues los volcamos a el archivo borrar.txt del escritorio del usuario

$espacio = Read-Host "Espacio a buscar"

Out-File -FilePath $env:USERPROFILE\Desktop\borrar.txt

foreach ($letra in 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z') {
    $archivos = Get-ChildItem  -Path "$($letra):\" -Filter $espacio -Recurse
    foreach ($archivo in $archivos) {
        $($archivo.FullName) | Out-File -Append $env:USERPROFILE\Desktop\borrar.txt
    }
}