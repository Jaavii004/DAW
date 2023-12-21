# Vamos a recorrer la altura de de la piramide con un for despues vamos a calcular cuantos espacios tenemos al principio 
# y luego vamoa a mostrarlos con un for y calcular cuantos mostramos que son el doble de lo que vale i para ir por derecha y izquierda

[int]$altura = Read-Host "Que altura quieres? "
Clear-Host
Write-Host

for ($i = 1; $i -le $altura; $i++) {
    $espacios = $altura - $i
    $asteriscos = $i * 2

    for ($j = 1; $j -le $espacios; $j++) {
        Write-Host " " -NoNewline
    }

    for ($o = 1; $o -lt $asteriscos; $o++) {
        Write-Host "*" -NoNewline 
    }
    Write-Host
}
