# Definir la carpeta de origen y la carpeta de destino
$source = "R:\"
$dest = "M:\BACKUP\"
$date = Get-Date -Format "yyyy-MM-dd"
$dateyes = (Get-Date).AddDays(-3)

# vamos a ver que archivos corresponden con el parametro de los ultimos 3 dias
$lastDayFiles = Get-ChildItem -Path $source | Where-Object{$_.LastWriteTime -gt $dateyes}

# si no hay archivos no hacemos nada 
if ($lastDayFiles.Count -ge 1) {
    # Comprimir los archivos modificados en un archivo .zip
    Compress-Archive -Path $lastDayFiles.FullName -DestinationPath "M:\BACKUP\ copy-incr-$date.zip" -Force
}