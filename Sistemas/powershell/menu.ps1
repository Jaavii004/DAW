while ($true) {
    Write-Host ""
    Write-Host "MENÚ"
    Write-Host "1. Listar los usuarios del sistema"
    Write-Host "2. Crear usuario"
    Write-Host "3. Cambiar contraseña de un usuario"
    Write-Host "4. Desactivar usuario"
    Write-Host "5. Borrar usuario"
    Write-Host "6. Listar los grupos de usuarios del sistema"
    Write-Host "7. Listar miembros de un grupo"
    Write-Host "8. Crear grupo"
    Write-Host "9. Borrar grupo"
    Write-Host "10. Añadir usuario a grupo"
    Write-Host "11. Borrar usuario de un grupo"
    Write-Host "12. Salir"

    $opcion = Read-Host "Seleccione una opción (1-12)"

    switch ($opcion) {
        1 {
            Get-WmiObject Win32_UserAccount | Select-Object Name
        }
        2 {
            $nombreUsuario = Read-Host "Ingrese el nombre del nuevo usuario"
            New-LocalUser -Name $nombreUsuario
            Write-Host "Usuario $nombreUsuario creado correctamente."
        }
        3 {
            $nombreUsuario = Read-Host "Ingrese el nombre del usuario"
            Set-LocalUser -Name $nombreUsuario -Password (Read-Host "Ingrese la nueva contraseña" -AsSecureString)
            Write-Host "Contraseña cambiada correctamente para el usuario $nombreUsuario."
        }
        4 {
            $nombreUsuario = Read-Host "Ingrese el nombre del usuario a desactivar"
            Disable-LocalUser -Name $nombreUsuario
            Write-Host "Usuario $nombreUsuario desactivado correctamente."
        }
        5 {
            $nombreUsuario = Read-Host "Ingrese el nombre del usuario a borrar"
            Remove-LocalUser -Name $nombreUsuario
            Write-Host "Usuario $nombreUsuario borrado correctamente."
        }
        6 {
            Get-WmiObject Win32_Group | Select-Object Name
        }
        7 {
            $nombreGrupo = Read-Host "Ingrese el nombre del grupo"
            Get-LocalGroupMember -Name $nombreGrupo | Select-Object Name
        }
        8 {
            $nombreGrupo = Read-Host "Ingrese el nombre del nuevo grupo"
            New-LocalGroup -Name $nombreGrupo
            Write-Host "Grupo $nombreGrupo creado correctamente."
        }
        9 {
            $nombreGrupo = Read-Host "Ingrese el nombre del grupo a borrar"
            Remove-LocalGroup -Name $nombreGrupo
            Write-Host "Grupo $nombreGrupo borrado correctamente."
        }
        10 {
            $nombreUsuario = Read-Host "Ingrese el nombre del usuario"
            $nombreGrupo = Read-Host "Ingrese el nombre del grupo"
            Add-LocalGroupMember -Group $nombreGrupo -Member $nombreUsuario
            Write-Host "Usuario $nombreUsuario añadido al grupo $nombreGrupo correctamente."
        }
        11 {
            $nombreUsuario = Read-Host "Ingrese el nombre del usuario"
            $nombreGrupo = Read-Host "Ingrese el nombre del grupo"
            Remove-LocalGroupMember -Group $nombreGrupo -Member $nombreUsuario
            Write-Host "Usuario $nombreUsuario eliminado del grupo $nombreGrupo correctamente."
        }
        12 {
            Write-Host "Saliendo del programa. ¡Hasta luego!"
            break
        }
        default {
            Write-Host "Opción no válida. Por favor, ingrese un número del 1 al 12."
        }
    }
}