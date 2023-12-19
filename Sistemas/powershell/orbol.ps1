for ($i = 0; $i -lt 4; $i++) {
    for ($j = 0; $j -lt $i; $j++) {
        Write-Host "* "
    }
}

for ($i = 4; $i -ge 0; $i--) {
    for ($j = 0; $j -lt $i; $j++) {
        Write-Host "* "
    }
}