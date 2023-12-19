for ($i = 0; $i -lt 4; $i++) {
    for ($j = 0; $j -lt $i; $j++) {
        $asteri += "* "
    }
    Write-Host $asteri
    $asteri = ""
}

for ($i = 4; $i -ge 0; $i--) {
    for ($j = 0; $j -lt $i; $j++) {
        $asteri = "* "
    }
    Write-Host $asteri
}