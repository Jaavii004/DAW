$fecha = Get-Date -Format "yyyy-MM-dd"

$rute = "F:\BACKUP"
if (-not (Test-Path $rute)) {
    Write-Host "No existe el recurso F:\BACKUP"
    New-Item -ItemType Directory -Path $rute
}

$zip = "F:\BACKUP\$fecha-docs_tots.zip"

Compress-Archive -Path "C:\Users\Administrador\Documents" -DestinationPath $zip