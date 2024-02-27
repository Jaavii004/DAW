Clear-Host
$destino = "\\wserver-profe\BACKUPEXAM\"

wbadmin start backup -backupTarget:$destino -include:R:\ -user:examen -password:1234QWERasdf -quiet
Clear-Host
Write-Host "Creado correctamente el backup en "$destino
