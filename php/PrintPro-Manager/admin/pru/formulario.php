<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../styles.css">
    <style>
        /* Estilos del modal */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            right: 10px; /* Posición a la derecha */
            top: 10px; /* Posición arriba */
        }

        .modal-content {
            padding: 20px;
            border: 1px solid #888;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            text-align: center;
            position: relative;
        }

        .success-modal {
            background-color: #5cb85c; /* Fondo verde para éxito */
        }

        .error-modal {
            background-color: #d9534f; /* Fondo rojo para error */
        }

        .success-icon {
            color: white; /* Color del icono en fondo verde */
            font-size: 50px;
        }

        .error-icon {
            color: white; /* Color del icono en fondo rojo */
            font-size: 50px;
        }
    </style>
</head>

<body>
    <header class="header">
        <!-- Código del encabezado omitido por brevedad -->
    </header>
    <main class="main">
        <!-- Código principal omitido por brevedad -->
        <div class="responsive-wrapper">
            <form action="actualizar_perfil.php" method="POST" onsubmit="return validarContraseña()">
                <!-- Resto del formulario omitido por brevedad -->
                <div class="form-group">
                    <label for="contraseña1">Contraseña:</label>
                    <input type="password" id="contraseña1" name="contraseña1" required>
                </div>

                <div class="form-group">
                    <label for="contraseña2">Repite la Contraseña:</label>
                    <input type="password" id="contraseña2" name="contraseña2" required>
                </div>
                <button type="button" onclick="mostrarPopup()">Actualizar Perfil</button>
            </form>
        </div>

        <!-- Modal -->
        <div id="myModal" class="modal">
            <div id="modalContent" class="modal-content">
                <div id="iconoPopup"></div>
                <div id="mensajePopup"></div>
            </div>
        </div>

        <script>
            function mostrarPopup() {
                var contraseña1 = document.getElementById("contraseña1").value;
                var contraseña2 = document.getElementById("contraseña2").value;
                var mensaje = document.getElementById("mensajePopup");
                var icono = document.getElementById("iconoPopup");
                var modalContent = document.getElementById("modalContent");

                if (contraseña1 != contraseña2) {
                    mensaje.innerHTML = "Las contraseñas no coinciden. Por favor, inténtalo de nuevo.";
                    modalContent.className = "modal-content error-modal";
                    icono.innerHTML = '<i class="error-icon">✘</i>';
                } else {
                    mensaje.innerHTML = "Las contraseñas coinciden. ¡Perfil actualizado!";
                    modalContent.className = "modal-content success-modal";
                    icono.innerHTML = '<i class="success-icon">✔</i>';
                }
                document.getElementById("myModal").style.display = "block";
                setTimeout(function () {
                    document.getElementById("myModal").style.display = "none";
                }, 2000); // Desaparece después de 2 segundos (2000 milisegundos)
            }
        </script>
    </main>
</body>

</html>
