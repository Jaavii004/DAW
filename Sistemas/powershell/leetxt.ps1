# Obtener todas las unidades del sistema
$unidades = Get-PSDrive -PSProvider FileSystem | Where-Object { $_.Free -ne $null }

# Recorrer cada unidad y buscar archivos .txt
foreach ($unidad in $unidades) {
    $rutaUnidad = $unidad.Root
    $archivosTxt = Get-ChildItem -Path $rutaUnidad -Filter *.txt -Recurse -ErrorAction SilentlyContinue

    # Mostrar la información de cada archivo .txt encontrado
    foreach ($archivo in $archivosTxt) {
        Write-Host "Ruta del archivo: $($archivo.FullName)"
        Write-Host "Última modificación: $($archivo.LastWriteTime)"
        Write-Host "-------------------"
    }
}

Write-Host "Proceso completado."


## Empieza 
# Obtener todas las unidades del sistema
$unidades = Get-PSDrive -PSProvider FileSystem | Where-Object { $_.Free -ne $null }

# Ruta del archivo de logs
$rutaLogs = "C:\Ruta\Donde\Quieres\Guardar\logs.txt"

# Crear o sobrescribir el archivo de logs
$null | Out-File -FilePath $rutaLogs

# Recorrer cada unidad y buscar archivos .txt
foreach ($unidad in $unidades) {
    $rutaUnidad = $unidad.Root
    $archivosTxt = Get-ChildItem -Path $rutaUnidad -Filter *.txt -Recurse -ErrorAction SilentlyContinue

    # Escribir la información de cada archivo .txt en el archivo de logs
    foreach ($archivo in $archivosTxt) {
        Add-Content -Path $rutaLogs -Value "Ruta del archivo: $($archivo.FullName)"
        Add-Content -Path $rutaLogs -Value "Última modificación: $($archivo.LastWriteTime)"
        Add-Content -Path $rutaLogs -Value "-------------------"
    }
}

Write-Host "Proceso completado. Los resultados se han guardado en $rutaLogs."
