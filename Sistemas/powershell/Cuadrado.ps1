[int]$num = Read-Host "Num: "

for ($i = 1; $i -le $num; $i++) {
    Write-Host ("$i " * $num)
}
Write-Host

for ($j = $num; $j -ge 1; $j--) {
    Write-Host ("$j " * $num)
}
