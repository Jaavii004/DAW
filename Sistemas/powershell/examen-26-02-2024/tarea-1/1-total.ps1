# Rutas utilizando variables de entorno
$rutaDesktop = "C:\Users\Administrador\Documents\"
$rutaBackup = "F:\BACKUP"

# Verificar si la ruta de origen existe
if (-not (Test-Path -Path $rutaDesktop)) {
    Write-Host "La ruta de origen no existe, creándola: $rutaDesktop"
    New-Item -Path $rutaDesktop -ItemType Directory -Force
}

# Verificar si la ruta de destino existe
if (-not (Test-Path -Path $rutaBackup)) {
    Write-Host "La ruta de destino no existe, creándola: $rutaBackup"
    New-Item -Path $rutaBackup -ItemType Directory -Force
}

# Crear dos archivos vacíos en la ruta de origen
for ($i = 1; $i -le 2; $i++) {
    $fileName = "Archivo$i.txt"
    $filePath = Join-Path -Path $rutaDesktop -ChildPath $fileName
    New-Item -Path $filePath -ItemType File -Force
}

# Fecha
$fecha = Get-Date -Format "yyyy-MM-dd"

# Ruta completa de origen y destino
$rutaArchivoZip = Join-Path -Path $rutaBackup -ChildPath "$fecha-CopiaSeguridad-tot.zip"

# Comprimir solo los archivos modificados en un archivo ZIP
Compress-Archive -Path (Get-ChildItem $rutaDesktop | Select-Object -ExpandProperty FullName) -DestinationPath $rutaArchivoZip -Force

# Borrar del documentos
Remove-Item $rutaDesktop\* -Recurse

# Descomprimir
Expand-Archive -Path $rutaArchivoZip -DestinationPath $rutaDesktop
Write-Host "Se ha copiado correctamente"
