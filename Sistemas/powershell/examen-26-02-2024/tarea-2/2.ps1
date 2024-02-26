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

# 4. Borrar X:\DAW1 y recuperar de copia de seguridad
Mostrar-MensajeExito "Borrando X:\DAW1 y recuperando desde la copia de seguridad en F:"
Remove-Item -Path X:\DAW1 -Recurse -Force
wbadmin start recovery -version:$(wbadmin get versions -backupTarget:F: | Select-Object -Last 1)

# 5. Realizar una copia de seguridad de el volumen X: en un recurso compartido por red de un compañero
$recursoCompartido = "\\nombre_del_equipo\recurso_compartido"
Mostrar-MensajeExito "Realizando copia de seguridad del volumen X: en $recursoCompartido"
if (-not (Test-Path $recursoCompartido)) {
    Mostrar-MensajeError "El recurso compartido $recursoCompartido no existe."
} else {
    wbadmin start backup -backupTarget:$recursoCompartido -include:X:\
}

# 6. Crear un fichero X:\DAW1\SI\Act-ps2.txt
New-Item -Path "X:\DAW1\SI\Act-ps2.txt" -ItemType File -Force

# 7. Actualizar la copia de seguridad en red realizada
Mostrar-MensajeExito "Actualizando copia de seguridad en $recursoCompartido"
wbadmin start backup -backupTarget:$recursoCompartido -allCritical

# 8. Borrar X:\DAW1 y recuperar usando la copia de seguridad
Mostrar-MensajeExito "Borrando X:\DAW1 y recuperando desde la copia de seguridad en $recursoCompartido"
Remove-Item -Path X:\DAW1 -Recurse -Force
wbadmin start recovery -version:$(wbadmin get versions -backupTarget:$recursoCompartido | Select-Object -Last 1)
