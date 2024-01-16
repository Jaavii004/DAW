Clear-Host

# Crear grupos si no existen
foreach ($group in "IES", "DAW", "DAM") {
    if (-not (Get-LocalGroup -Name $group -ErrorAction SilentlyContinue)) {
        New-LocalGroup -Name $group
        Write-Host "Grupo $group : Creado"
        Enable-LocalUser -Name $user
    }else{
        Write-Host "Grupo $group : Ya existe"
        
    }
}
Write-Host

# Crear usuarios si no existen
foreach ($user in "Jaime", "Belen", "Marta", "Luis", "Carlos", "Juan") {
    if (-not (Get-LocalUser -Name $user -ErrorAction SilentlyContinue)) {
        New-LocalUser -Name $user
        Write-Host "Usuario $user : Creado"
    }else{
        Write-Host "Usuario $user : Ya existe"
    }
}

# Crear carpetas si no existen
Write-Host
foreach ($path in "C:\SENIA", "C:\SENIA\APUNTES", "C:\SENIA\APUNTES\DAW", "C:\SENIA\APUNTES\DAM") {
    if (-not (Test-Path $path)) {
        New-Item -Path $path -ItemType Directory
        Write-Host "Ruta $path : Creada"
    }else{
        Write-Host "Ruta $path : Ya existe"
    }
}


$seniaPath = "C:\SENIA"
$apuntesPath = "C:\SENIA\APUNTES"
$dawPath = "C:\SENIA\APUNTES\DAW"
$damPath = "C:\SENIA\APUNTES\DAM"

# Establecer permisos con ACLs
# C:\SENIA
$iesAcl = Get-Acl "C:\SENIA"
$iesRule = New-Object System.Security.AccessControl.FileSystemAccessRule("C:\SENIA", "Read", "Allow")
$iesAcl.AddAccessRule($iesRule)
Set-Acl $seniaPath $iesAcl

# C:\SENIA\APUNTES
$juanAcl = Get-Acl $apuntesPath
$juanRule = New-Object System.Security.AccessControl.FileSystemAccessRule($juanUser, "FullControl", "Allow")
$juanAcl.AddAccessRule($juanRule)
Set-Acl $apuntesPath $juanAcl

# C:\SENIA\APUNTES\DAW
$dawAcl = Get-Acl $dawPath
$damAcl = Get-Acl $damPath

$dawRule = New-Object System.Security.AccessControl.FileSystemAccessRule($dawGroup, "Read, Write, Execute", "Allow")
$damRule = New-Object System.Security.AccessControl.FileSystemAccessRule($damGroup, "Read", "Allow")

$dawAcl.AddAccessRule($dawRule)
$damAcl.AddAccessRule($damRule)

Set-Acl $dawPath $dawAcl
Set-Acl $damPath $damAcl
