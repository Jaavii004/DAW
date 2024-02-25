#Función para mostrar mensajes de error
function Mostrar-MensajeError {
    param([string]$mensaje)
    Write-Host "ERROR: $mensaje" -ForegroundColor Red
}

# Función para mostrar mensajes de éxito
function Mostrar-MensajeExito {
    param([string]$mensaje)
    Write-Host "Éxito: $mensaje" -ForegroundColor Green
}

# 1. Crear una copia de seguridad de el contenido de “usuarios” del sistema y de X:\DAW1 y guardar la copia de seguridad en el volumen F:
Mostrar-MensajeExito "Creando copia de seguridad en F:"
if (-not (Test-Path R:\)) {
    Mostrar-MensajeError "El volumen x: no existe."
} else {
    wbadmin start backup -backupTarget:R: -include:C:\users,X:\DAW1
}

# 2. Crear la siguiente estructura de carpetas
$carpetas = @("X:\DAW1\SI\Act-ps1.txt", "X:\DAW1\BBDD", "X:\DAW1\FOL")
foreach ($carpeta in $carpetas) {
    New-Item -Path $carpeta -ItemType Directory -Force
}

# 3. Actualizar la copia de seguridad
Mostrar-MensajeExito "Actualizando copia de seguridad en F:"
if (-not (Test-Path R:\)) {
    Mostrar-MensajeError "El volumen F: no existe."
} else {
    wbadmin start backup -backupTarget:R:
}

# 4. Borrar X:\DAW1 y recuperar de copia de seguridad
Mostrar-MensajeExito "Borrando X:\DAW1 y recuperando desde la copia de seguridad en F:"
Remove-Item -Path X:\DAW1 -Recurse -Force
wbadmin start recovery -version:$(wbadmin get versions -backupTarget:R: | Select-Object -Last 1)
