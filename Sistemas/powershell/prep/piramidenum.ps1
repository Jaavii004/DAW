[int]$var = Read-Host "Pon numero "

for ($i = 0; $i -lt $var; $i++) {
    for ($j = 0; $j -le $i; $j++) {
        $asteri += $var-$i
    }
    Write-Host $asteri
    $asteri = ""
}