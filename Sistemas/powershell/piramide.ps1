# Definir la altura de la pirámide
$altura = 5

# Bucle para cada nivel de la pirámide
for ($i = 1; $i -le $altura; $i++) {
    # Calcular la cantidad de espacios en blanco y asteriscos en cada nivel 
    $espacios = $altura - $i
    $asteriscos = $i * 2 - 1
    # Imprimir espacios en blanco
    for ($j = 1; $j -le $espacios; $j++) {
        Write-Host -NoNewline (" ")
    }

    # Imprimir asteriscos
    for ($o = 1; $o -le $asteriscos; $o++) {
        Write-Host -NoNewline ("*")
    }
    Write-Host
}
