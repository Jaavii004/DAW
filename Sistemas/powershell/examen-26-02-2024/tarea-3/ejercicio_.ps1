# Definir las variables
$horaProgramada = "02:00"  # Cambiar según la hora deseada
$rutaBackup = "F:\Backup"
$documentoModificacion = "C:\Ruta\Del\Documento.txt"
$nombreCopia = "NombreCopia"
$servidorProfesor = "NombreServidorProfesor"

# 1. Programar el backup diario
wbadmin enable backup -schedule:$horaProgramada -quiet

# 2. Añadir un documento antes de la segunda copia
Copy-Item $documentoModificacion "$rutaBackup\$nombreCopia"

# 3. Borrar xxxxx y restaurar la versión necesaria
Remove-Item "$rutaBackup\xxxxx" -Force
wbadmin start recovery -version:<VersiónNecesaria> -itemType:File -items:$rutaBackup -quiet

# 4. Deshabilitar la realización de la copia de seguridad
wbadmin disable backup -quiet

# 5. Comprobar que ya no se lanza a la hora programada
# (Puedes verificar manualmente el programador de tareas)

# 6. Volver a habilitar la copia con la misma programación
wbadmin enable backup -schedule:$horaProgramada -quiet

# 7. Borrar las copias realizadas hasta ahora
wbadmin delete backup -keepVersions:0 -quiet