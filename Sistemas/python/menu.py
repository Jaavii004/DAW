import os
import pwd
import grp
import spwd

def listar_usuarios():
    usuarios = [user.pw_name for user in pwd.getpwall()]
    print("Usuarios del sistema:")
    print("\n".join(usuarios))

def crear_usuario():
    nombre_usuario = input("Ingrese el nombre del nuevo usuario: ")
    os.system(f"sudo useradd {nombre_usuario}")
    print(f"Usuario {nombre_usuario} creado correctamente.")

def cambiar_contraseña():
    nombre_usuario = input("Ingrese el nombre del usuario: ")
    os.system(f"sudo passwd {nombre_usuario}")
    print(f"Contraseña cambiada correctamente para el usuario {nombre_usuario}.")

# Implementa las demás funciones según sea necesario

while True:
    print("\nMENÚ")
    print("1. Listar los usuarios del sistema")
    print("2. Crear usuario")
    print("3. Cambiar contraseña de un usuario")
    print("4. Desactivar usuario")
    print("5. Borrar usuario")
    print("6. Listar los grupos de usuarios del sistema")
    print("7. Listar miembros de un grupo")
    print("8. Crear grupo")
    print("9. Borrar grupo")
    print("10. Añadir usuario a grupo")
    print("11. Borrar usuario de un grupo")
    print("12. Salir")

    opcion = input("Seleccione una opción (1-12): ")

    if opcion == "1":
        listar_usuarios()
    elif opcion == "2":
        crear_usuario()
    elif opcion == "3":
        cambiar_contraseña()
    # Agrega el resto de las opciones aquí
    elif opcion == "12":
        print("Saliendo del programa. ¡Hasta luego!")
        break
    else:
        print("Opción no válida. Por favor, ingrese un número del 1 al 12.")
