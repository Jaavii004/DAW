# Tarea 1: Crear una copia de seguridad del contenido de "usuarios" del sistema y de X:\DAW1 y guardarla en el volumen F:
$DAW1Path = "X:\DAW1"
$volumenBackup = "F:"
$fechaHoraCopiaSeguridad = ""

# Ejecutar el comando wbadmin para realizar la copia de seguridad y obtener la fecha y hora de la versión creada
$backupResult = wbadmin start backup -include:$DAW1Path -backupTarget:$volumenBackup -quiet
if ($backupResult.ExitCode -eq 0) {
    $fechaHoraCopiaSeguridad = Get-Date -Format "MM/dd/yyyy-HH:mm"
    Write-Host "La copia de seguridad se realizó correctamente. Fecha y hora de la versión: $fechaHoraCopiaSeguridad"
} else {
    Write-Host "Error al realizar la copia de seguridad."
}

# Tarea 2: Crear la siguiente estructura de directorios utilizando PowerShell
$carpetas = @("X:\DAW1\SI\Act-ps1.txt", "X:\DAW1\BBDD", "X:\DAW1\FOL")
foreach ($carpeta in $carpetas) {
    New-Item -Path $carpeta -ItemType Directory -Force
}

# Tarea 3: Actualizar la copia de seguridad
$backupResult = wbadmin start backup -include:$DAW1Path -backupTarget:$volumenBackup -quiet

# Tarea 4: Borrar X:\DAW1 y recuperar de copia de seguridad
Remove-Item -Path $DAW1Path -Recurse -Force
$restoreResult = wbadmin start recovery -version:$fechaHoraCopiaSeguridad -itemType:Volume -backupTarget:$volumenBackup -items:$DAW1Path -quiet
