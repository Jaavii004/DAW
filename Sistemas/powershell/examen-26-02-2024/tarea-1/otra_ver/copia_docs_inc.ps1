# Definir la carpeta de origen y la carpeta de destino
$source = "$HOME\Documents"
$dest = "F:\BACKUP\"
$date = Get-Date -Format "yyyy-MM-dd"
$dateyes = (Get-Date).AddDays(-1)
$zip = "F:\BACKUP\$date-docs_inc.zip"

$lastDayFiles = Get-ChildItem -Path $source | Where-Object{$_.LastWriteTime -gt $dateyes}

if ($lastDayFiles.Count -gt 0) {
    # Comprimir los archivos modificados en un archivo .zip
    Compress-Archive -Path $lastDayFiles.FullName -DestinationPath $zip -Force
}