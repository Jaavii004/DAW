# Definir nombre de usuario y contraseña
$usuario = "prueba"
$contrasena = ConvertTo-SecureString "1234" -AsPlainText -Force

# Crear usuario
New-LocalUser -Name $usuario -Password $contrasena -PasswordNeverExpires $true

# Establecer restricciones de ejecución
$restriccion = "C:\Windows\System32\MicrosoftEdge.exe"
$regla = "Deny_All_Edge"

# Crear nueva regla de restricción
New-AppLockerPolicy -RuleName $regla -Action Deny -User Everyone -Path $restriccion -AppIDPath "*"

# Activar AppLocker
Set-AppLockerPolicy -PolicyPath "C:\Windows\System32\AppLocker\Policy.xml" -RuleMergeMode Enforce

Write-Host "Usuario '$usuario' creado con contraseña '1234'. Restricción de ejecución de Edge aplicada."
