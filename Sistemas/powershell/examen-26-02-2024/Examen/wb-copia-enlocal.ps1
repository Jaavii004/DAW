Clear-Host
$destino = "M:\"

wbadmin start backup -backupTarget:$destino -include:R:\ -quiet
Clear-Host
Write-Host "Creado correctamente el backup en "$destino
