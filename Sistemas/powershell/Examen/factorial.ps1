# Javier Puertas Rosello
# Lo metemos todo en un bucle para que se repita hasta que el usuario quiera
# Primero hago un for para las veces que me a pedido el usuario
# Despues ese numero lo voy multiplicando por el numero anterior 
# excepto en la primera vez que le pongo un 1 que a la hora de 
# multiplicar no va a valer nada porque cualquiera multiplicado
# por 1 da el mismo numero
# y despues un if para solo mostrar la x cuando va un numero 
# detras y no al final

Clear-Host
$salir = 1
do {
    Write-Host "Para salir usa el 0. Si no pones nada interpretamos que te quieres ir."
    [int] $num = Read-Host "Que numero quieres saber en factorial"
    if ($num -eq 0) {
        Write-Host "Salimos de la calculadora factorial"
        $salir = 0
    }else{
        # Inicializar las variables
        $fact = ""
        $resultado = 1

        for ($i = 1; $i -le $num; $i++) {
            $fact += $i
            $resultado *= $i
            if ($i -ne $num) {
                $fact += "x"
            }
        }
        Write-Host $num"! = "$fact" = "$resultado
    }
} while ($salir -eq 1)