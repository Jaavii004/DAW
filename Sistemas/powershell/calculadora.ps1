# Author Javier Puertas Rosello

do {
    # Mostrar menu
    Write-Host "Selecciona una operación:"
    Write-Host "1. Sumar"
    Write-Host "2. Restar"
    Write-Host "3. Multiplicar"
    Write-Host "4. Dividir"
    Write-Host "5. Salir"

    $opcion = Read-Host "Ingresa el número de la operación"

    switch ($opcion) {
        1 {
            [double]$num1 = Read-Host "Ingresa el primer número"
            [double]$num2 = Read-Host "Ingresa el segundo número"
            PedrirNum
            $resultado = $num1 + $num2
            Write-Output "Suma: $resultado"
        }
        2 {
            [double]$num1 = Read-Host "Ingresa el primer número"
            [double]$num2 = Read-Host "Ingresa el segundo número"
            $resultado = $num1 - $num2
            Write-Output "Resta: $resultado" 
        }
        3 {
            [double]$num1 = Read-Host "Ingresa el primer número"
            [double]$num2 = Read-Host "Ingresa el segundo número"
            $resultado = $num1 * $num2
            Write-Output "Multiplicación: $resultado"
        }
        4 {
            [double]$num1 = Read-Host "Ingresa el primer número"
            [double]$num2 = Read-Host "Ingresa el segundo número"
            if ($num2 -eq 0) {
                Write-Output "Error: No se puede dividir por cero."
            } else {
                $resultado = $num1 / $num2
                Write-Output "División: $resultado"
            }
        }
        5 {
            Write-host "Salimos"
        }
        default { 
            Write-Host "Opción no válida. Inténtalo de nuevo." 
        }
    }
} while ($opcion -ne 5)
