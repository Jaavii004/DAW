# Generar 6 números aleatorios diferentes entre 1 y 49
$randomNumbers = Get-Random -Minimum 1 -Maximum 50 | Select-Object -Unique

# Verificar si se generaron menos de 6 números únicos y generar los faltantes
while ($randomNumbers.Count -lt 6) {
    $missingNumbers = Get-Random -Count (6 - $randomNumbers.Count) -Minimum 1 -Maximum 50 | Select-Object -Unique
    $randomNumbers += $missingNumbers
}

# Mostrar los números generados
Write-Host "Los números de la Bonoloto son: $randomNumbers"