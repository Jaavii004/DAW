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

# 9. Realizar una copia de seguridad de la unidad X: en \\WSERVER-PROFE\COMPARTIR
$recursoCompartido2 = "\\WSERVER-PROFE\compartir"
Mostrar-MensajeExito "Realizando copia de seguridad del volumen X: en $recursoCompartido2"
if (-not (Test-Path $recursoCompartido2)) {
    Mostrar-MensajeError "El recurso compartido $recursoCompartido2 no existe."
} else {
    wbadmin start backup -backupTarget:\\WSERVER-PROFE\Compartir -include:X:\DAW1\SI\Act-ps3.txt -user:prova -password:1234QWERasdf -quiet 
}

# 10. Crear un fichero X:\DAW1\SI\Act-ps3.txt
New-Item -Path "X:\DAW1\SI\Act-ps3.txt" -ItemType File -Force

# 11. Actualizar la copia de seguridad en red realizada
Mostrar-MensajeExito "Actualizando copia de seguridad en $recursoCompartido2"
wbadmin start backup -backupTarget:$recursoCompartido2 

# 12. Borrar X:\DAW1 y recuperar usando la copia de seguridad
Mostrar-MensajeExito "Borrando X:\DAW1 y recuperando desde la copia de seguridad en $recursoCompartido2"
Remove-Item -Path X:\DAW1 -Recurse -Force
$ultimaVersion = (wbadmin get versions -backupTarget:$recursoCompartido2 | Select-Object -Last 1).backupTime
wbadmin start recovery -version:$ultimaVersion -backupTarget:$recursoCompartido2 -itemType:Volume -items:X:\