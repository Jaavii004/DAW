# Javier Puertas Rosello
# Vamos a crear un bucle infinito que lo que vamos a hacer
# es cuando eliga salir sea 0 y salimos
# Despues dentro del switch vamos a comprobar cada caso para ir haciendo el menu

$salir = 1
do {
    Clear-Host
    Write-Host "A. Crear Directorio"
    Write-Host "B. Copiar Directorio"
    Write-Host "C. Borrar Directorio"
    Write-Host "D. Mover Directorio"
    Write-Host "E. Salir"

    $opcion = Read-Host "Eligue una opcion"

    switch ($opcion) {
        'A' {
            $nombreDir = Read-Host "Nombre o ruta del directorio a crear"
            New-Item -ItemType Directory -Path $nombreDir
            Read-Host "Pulsa Enter para continuar"
        }
        'B' {
            $origen = Read-Host "Ruta Directorio origen"
            $destino = Read-Host "Ruta Directorio  destino"
            Copy-Item $origen -Destination $destino
            Read-Host "Pulsa Enter para continuar"
        }
        'C' {
            $DirBorrar = Read-Host "Directorio a borrar"
            Remove-Item $DirBorrar
            Read-Host "Pulsa Enter para continuar"
        }
        'D' {
            $origen = Read-Host "Que directorio movemos"
            $destino = Read-Host "Donde lo movemos"
            Move-Item $origen -Destination $destino
            Read-Host "Pulsa Enter para continuar"
        }
        'E' {
            Write-Host "Salir"
            $salir = 0
        }
        # Si no nos pone ningunba de las anterioires diremos que se a equivocado
        default {
            Write-Host "Pon una letra correcta."
            Read-Host "Pulsa Enter para continuar"
        }
    }
} while ($salir -eq 1)