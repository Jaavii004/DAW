# Definir la altura de la pirámide
$altura = 5

# Bucle para cada nivel de la pirámide
for ($i = 1; $i -le $altura; $i++) {
    # Calcular la cantidad de espacios en blanco y asteriscos en cada nivel
    $espacios = $altura - $i
    $asteriscos = $i * 2 - 1

    # Imprimir espacios en blanco
    Write-Host -NoNewline (" " * $espacios)

    # Imprimir asteriscos
    Write-Host -NoNewline ("*" * $asteriscos)

    # Nueva línea para el próximo nivel
    Write-Host
}
