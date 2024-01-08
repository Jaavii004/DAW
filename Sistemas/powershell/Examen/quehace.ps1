# Javier Puertas Rosello

# Aqui empieza declarando las variables
$n = "txt", "doc", "xls", "iso"
$c = 0

# Aqui hacemos un for que todos los parametros de $n se 
# los ira pasando uno a uno a $s 
foreach ($s in $n) {
    # Vamos incrementando el valor de $c
    $c += 1
    # Mostramos el valor de $s
    Write-Host "$s"
    # Es el valor que vamos a ir incrementando
    Write-Host $c
}
