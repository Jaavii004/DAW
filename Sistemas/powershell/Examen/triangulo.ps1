# Javier Puertas Rosello
# Hago un for para recorrer las veces que ponga el usuario
# y luego dentro hago otro para saber cuantos veces tengo que mostrar 
# y si es par muestro una A y si no una B

[int]$var = Read-Host "Altura n del triangulo "

for ($i = 0; $i -lt $var; $i++) {
    for ($j = 0; $j -le $i; $j++) {
        if ($i % 2 -eq 0) {
            Write-Host "A " -NoNewline
        }else{
            Write-Host "B " -NoNewline
        }
    }
    Write-Host
}