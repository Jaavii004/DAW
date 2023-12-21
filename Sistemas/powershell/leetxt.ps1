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
