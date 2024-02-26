# Iniciar una copia de seguridad completa del sistema
wbadmin start backup -backupTarget:"F:" -include:"X:\DAW1" -quiet

# Mostrar un mensaje de finalización
Write-Host "Copia de seguridad completada correctamente."