$salir = 1
do {
    Clear-Host
    Write-Host "A. Crear Fichero"
    Write-Host "B. Copiar Fichero"
    Write-Host "C. Borrar Fichero"
    Write-Host "D. Mover Fichero"
    Write-Host "E. Salir"

    $opcion = Read-Host "Selecciona una opción: "

    switch ($opcion) {
        'A' {
            $nombreArchivo = Read-Host "Introduce el nombre del archivo a crear"
            New-Item -ItemType File -Path $nombreArchivo
        }
        'B' {
            $origen = Read-Host "Introduce la ruta del archivo a copiar"
            $destino = Read-Host "Introduce la ruta de destino"
            Copy-Item $origen -Destination $destino
        }
        'C' {
            $archivoABorrar = Read-Host "Introduce la ruta del archivo a borrar"
            Remove-Item $archivoABorrar
        }
        'D' {
            $origen = Read-Host "Nombre archivo a mover"
            $destino = Read-Host "Donde lo quieres mover"
            Move-Item $origen -Destination $destino
        }
        'E' {
            Write-Host "Salir"
            $salir = 0
        }
        default {
            Write-Host "Opción no válida. Inténtalo de nuevo."
        }
    }
    Read-Host
} while ($salir -eq 1)  # Bucle infinito
