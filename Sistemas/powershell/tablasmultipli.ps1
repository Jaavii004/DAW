[int]$tabla = Read-Host "Que tabla quieres? "

for ($i = 0; $i -le 10; $i++) {
    [int]$resultado = $tabla*$i
    Write-Host $tabla"x"$i" = "$resultado
}
