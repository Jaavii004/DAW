# Generar combinación aleatoria de la Bonoloto
$combinacion = @()

# Generar 6 números principales
for ($i = 0; $i -lt 6; $i++) {
    $numero = Get-Random -Minimum 1 -Maximum 49
    while ($combinacion -contains $numero) {
        $numero = Get-Random -Minimum 1 -Maximum 49
    }
    $combinacion += $numero
}

# Ordenar los números de manera ascendente
$combinacion = $combinacion | Sort-Object

# Generar 2 reintegros
$reintegros = Get-Random -Minimum 1 -Maximum 10

# Mostrar los resultados
Write-Host "Combinación de la Bonoloto: $combinacion"
Write-Host "Reintegros: $reintegros"
