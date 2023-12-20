# Lista de palabras para adivinar
$listaDePalabras = @("perro", "gato", "elefante", "tigre", "león", "jirafa")

# Seleccionar aleatoriamente una palabra
$palabraSeleccionada = Get-Random -InputObject $listaDePalabras

# Número máximo de intentos
$maxIntentos = 6
$intentos = 0

# Inicializar un array para almacenar las letras adivinadas
$letrasAdivinadas = @(" " * $palabraSeleccionada.Length)

# Función para mostrar el estado actual de la palabra
function MostrarPalabra {
    Write-Host "Palabra actual: $($letrasAdivinadas -join "")"
}

# Bucle principal del juego
while ($intentos -lt $maxIntentos -and $letrasAdivinadas -contains " ") {
    MostrarPalabra
    $adivinanza = Read-Host "Ingresa una letra: " -Prompt

    # Validar la entrada del usuario
    if ($adivinanza -match "^[a-zA-Z]$") {
        # Verificar si la letra está en la palabra
        if ($palabraSeleccionada -contains $adivinanza) {
            Write-Host "¡Bien hecho! La letra '$adivinanza' está en la palabra."

            # Actualizar el array de letras adivinadas con la nueva letra
            $indices = 0..($palabraSeleccionada.Length - 1) | Where-Object { $palabraSeleccionada[$_] -eq $adivinanza }
            foreach ($indice in $indices) {
                $letrasAdivinadas[$indice] = $adivinanza
            }
        } else {
            Write-Host "¡Incorrecto! La letra '$adivinanza' no está en la palabra."
        }
    } else {
        Write-Host "Entrada no válida. Ingresa una letra válida."
    }

    $intentos++
}

# Mostrar el resultado final
MostrarPalabra

if ($letrasAdivinadas -notcontains " ") {
    Write-Host "¡Felicidades! Has adivinado la palabra: $palabraSeleccionada"
} else {
    Write-Host "Lo siento, has agotado tus intentos. La palabra era: $palabraSeleccionada"
}
