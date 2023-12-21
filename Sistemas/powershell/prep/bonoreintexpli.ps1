# Voy a hacer un for primero para comprobar sacar los 6 numeros
# y un while para que si esta sacar uno nuevo y luego en los reintegros solo 2 veces en el for
$bonoloto = @()

for ($i = 0; $i -lt 6; $i++) {
    $numero = Get-Random -Minimum 1 -Maximum 49
    while ($bonoloto -contains $numero) {
        $numero = Get-Random -Minimum 1 -Maximum 49
    }
    $bonoloto += $numero
}

$reintegros = @()

for ($i = 0; $i -lt 2; $i++) {
    $numero = Get-Random -Minimum 1 -Maximum 10
    while ($reintegros -contains $numero) {
        $numero = Get-Random -Minimum 1 -Maximum 10
    }
    $reintegros += $numero
}

Write-Host $bonoloto" + "$reintegros