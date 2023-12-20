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
#for ($i = 0; $i -lt 5; $i++) {
#    for ($j = $i + 1; $j -lt 5; $j++) {
#        if ($combinacion[$i] -gt $combinacion[$j]) {
#            $temp = $combinacion[$i]
#            $combinacion[$i] = $combinacion[$j]
#            $combinacion[$j] = $temp
#        }
#    }
#}

$reintegros = @()

# Generar 6 números principales
for ($i = 0; $i -lt 2; $i++) {
    $numero = Get-Random -Minimum 1 -Maximum 10
    while ($reintegros -contains $numero) {
        $numero = Get-Random -Minimum 1 -Maximum 10
    }
    $reintegros += $numero
}

# Mostrar los resultados
Write-Host "Combinación de la Bonoloto: $combinacion"
Write-Host "Reintegros: $reintegros"
