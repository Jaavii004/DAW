# Usuario
$usuario = "examen"
$contra = "1234QWERasdf"

# Ruta del archivo ZIP
$rutaArchivoZip = "\\wserver-profe\BACKUPEXAM\img-2023-01-12.zip"

# Donde dejamos las imagenes
$rutaDestinoImg = "R:\BIPAI-WEB\img"

# Crear directorio si no existe
if (-not (Test-Path $rutaDestinoImg)) {
    New-Item -ItemType Directory -Path $rutaDestinoImg -Force
}

# Descomprimir el archivo ZIP
Expand-Archive -Path $rutaArchivoZip -DestinationPath $rutaDestinoImg -Force

# Mensaje de confirmación
Write-Host "Se han copiado las imágenes correctamente a $rutaDestinoImg"