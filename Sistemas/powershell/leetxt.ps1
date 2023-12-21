# Obtener la ruta del directorio raíz (puedes cambiarla según tus necesidades)
$rutaRaiz = "C:\" 

# Obtener todos los archivos .txt en el directorio y subdirectorios
$archivosTxt = Get-ChildItem -Path $rutaRaiz -Filter *.txt -Recurse

# Recorrer cada archivo y mostrar su contenido
foreach ($archivo in $archivosTxt) {
    Write-Host "Contenido de $($archivo.FullName):"
    Get-Content $archivo.FullName
    Write-Host "`n-------------------`n"
}

Write-Host "Proceso completado."
