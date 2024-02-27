# Rutas que vamos a utilizar
$rutaInicio = "R:\"
$rutaBackup = "M:\BACKUP"
# Fecha para saber la fecha en formato Año-mes-dia
$fecha = Get-Date -Format "yyyy-MM-dd"

# Verificar si la ruta de Backup
if (-not (Test-Path -Path $rutaBackup)) {
    Write-Host "La ruta de destino no existe, creándola: $rutaBackup"
    New-Item -Path $rutaBackup -ItemType Directory -Force
}else{
    Write-Host "La ruta de destino existe"
}

# Comprimir todos los archivos
Compress-Archive -Path (Get-ChildItem $rutaInicio | Select-Object -ExpandProperty FullName) -DestinationPath $rutaBackup"\copy-total-$fecha.zip" -Force
Write-Host "Comprimido exitosamente"
