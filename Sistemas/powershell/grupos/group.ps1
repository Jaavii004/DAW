# Crear grupos si no existen
$iesGroup = "IES"
$dawGroup = "DAW"
$damGroup = "DAM"

if (-not (Get-LocalGroup -Name $iesGroup -ErrorAction SilentlyContinue)) {
    New-LocalGroup -Name $iesGroup
}

if (-not (Get-LocalGroup -Name $dawGroup -ErrorAction SilentlyContinue)) {
    New-LocalGroup -Name $dawGroup
}

if (-not (Get-LocalGroup -Name $damGroup -ErrorAction SilentlyContinue)) {
    New-LocalGroup -Name $damGroup
}

# Crear usuarios si no existen
$jaimeUser = "Jaime"
$belenUser = "Belén"
$martaUser = "Marta"
$luisUser = "Luis"
$carlosUser = "Carlos"
$juanUser = "Juan"

foreach ($user in $jaimeUser, $belenUser, $martaUser, $luisUser, $carlosUser, $juanUser) {
    if (-not (Get-LocalUser -Name $user -ErrorAction SilentlyContinue)) {
        New-LocalUser -Name $user
    }
}

# Crear carpetas si no existen
$seniaPath = "C:\SENIA"
$apuntesPath = "C:\SENIA\APUNTES"
$dawPath = "C:\SENIA\APUNTES\DAW"
$damPath = "C:\SENIA\APUNTES\DAM"

foreach ($path in $seniaPath, $apuntesPath, $dawPath, $damPath) {
    if (-not (Test-Path $path)) {
        New-Item -Path $path -ItemType Directory
    }
}

# Establecer permisos
# C:\SENIA
icacls $seniaPath /grant $iesGroup:"(R)"

# C:\SENIA\APUNTES
icacls $apuntesPath /grant $juanUser:"(F)"

# C:\SENIA\APUNTES\DAW
icacls $dawPath /grant $dawGroup:"(M)"
icacls $dawPath /inheritance:r /grant $damGroup:"(N)"

# C:\SENIA\APUNTES\DAM
icacls $damPath /grant $damGroup:"(M)"
icacls $damPath /inheritance:r /grant $dawGroup:"(N)"
