# Ruta de origen
$rutaOrigen = "C:\Users\Administrador\Documents\"

# Ruta de destino para la copia de seguridad
$rutaBackup = "F:\BACKUP"

# Obtener la fecha actual
$fechaActual = Get-Date -Format "yyyy-MM-dd"

# Crear la carpeta de respaldo con la fecha actual si no existe
$carpetaBackup = Join-Path -Path $rutaBackup -ChildPath $fechaActual
New-Item -ItemType Directory -Path $carpetaBackup -Force

# Obtener el nombre del último archivo de copia de seguridad "-tot.zip" si existe
$ultimoArchivoBackup = Get-ChildItem -Path $rutaBackup -Filter "*-tot.zip" | Sort-Object LastWriteTime -Descending | Select-Object -First 1

if ($ultimoArchivoBackup -eq $null) {
    # Si es la primera copia o no hay copias "-tot.zip", copiar todos los archivos
    Copy-Item -Path "$rutaOrigen\*" -Destination $carpetaBackup -Recurse -Force
} else {
    # Copiar solo los archivos modificados desde la última copia "-tot.zip"
    $fechaUltimoBackup = $ultimoArchivoBackup.LastWriteTime
    $archivosACopiar = Get-ChildItem -Path $rutaOrigen | Where-Object { $_.LastWriteTime -gt $fechaUltimoBackup }
    Copy-Item -Path $archivosACopiar.FullName -Destination $carpetaBackup -Recurse -Force
}

# Comprimir la carpeta de respaldo en un archivo zip
$nombreArchivoZip = "$fechaActual-docs_dif.zip"
$rutaArchivoZip = Join-Path -Path $rutaBackup -ChildPath $nombreArchivoZip
Compress-Archive -Path $carpetaBackup\* -DestinationPath $rutaArchivoZip -Force

# Verificar si el archivo zip no existe antes de crearlo
if (-not (Test-Path $rutaArchivoZip)) {
    # Comprimir la carpeta de respaldo en un archivo zip
    Compress-Archive -Path $carpetaBackup\* -DestinationPath $rutaArchivoZip -Force
    Write-Host "Archivo de copia de seguridad creado en: $rutaArchivoZip"
} else {
    Write-Host "El archivo de copia de seguridad ya existe en la ruta: $rutaArchivoZip. No se ha creado otro archivo."
}

# Eliminar los archivos originales, excluyendo el archivo zip
Remove-Item -Recurse -Exclude *.zip -Path $rutaBackup\*

Write-Host "Copia de seguridad incremental completada. Archivo creado: $rutaArchivoZip"