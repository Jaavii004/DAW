function Sumar {
    param (
        [double]$num1,
        [double]$num2
    )
    $resultado = $num1 + $num2
    Write-Output "Suma: $resultado"
}

function Restar {
    param (
        [double]$num1,
        [double]$num2
    )
    $resultado = $num1 - $num2
    Write-Output "Resta: $resultado"
}

function Multiplicar {
    param (
        [double]$num1,
        [double]$num2
    )
    $resultado = $num1 * $num2
    Write-Output "Multiplicación: $resultado"
}

function Dividir {
    param (
        [double]$num1,
        [double]$num2
    )
    if ($num2 -eq 0) {
        Write-Output "Error: No se puede dividir por cero."
    } else {
        $resultado = $num1 / $num2
        Write-Output "División: $resultado"
    }
}

# Menú principal
do {
    Write-Host "Selecciona una operación:"
    Write-Host "1. Sumar"
    Write-Host "2. Restar"
    Write-Host "3. Multiplicar"
    Write-Host "4. Dividir"
    Write-Host "5. Salir"

    $opcion = Read-Host "Ingresa el número de la operación"

    switch ($opcion) {
        1 { Sumar (Read-Host "Ingresa el primer número") (Read-Host "Ingresa el segundo número") }
        2 { Restar (Read-Host "Ingresa el primer número") (Read-Host "Ingresa el segundo número") }
        3 { Multiplicar (Read-Host "Ingresa el primer número") (Read-Host "Ingresa el segundo número") }
        4 { Dividir (Read-Host "Ingresa el primer número") (Read-Host "Ingresa el segundo número") }
        5 { break }
        default { Write-Host "Opción no válida. Inténtalo de nuevo." }
    }
} while ($opcion -ne 5)
