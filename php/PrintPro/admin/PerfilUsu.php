<?php
// Importar el archivo config.php
include '../config/config.php';
include '../login/usuariologin.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil <?php echo namePage; ?></title>
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <header class="header">
        <div class="header-content responsive-wrapper">
            <div class="header-logo">
                <a href="#">
                    <div>
                        <img src="../img/Logo.png" class="logo-img" />
                    </div>
                    <p></p>
                </a>
            </div>
            <div class="header-navigation">
                <nav class="header-navigation-links">
                    <a href="index.php"> Home </a>
                    <a href="IncidenciasAbiertas.php"> Incidencias </a>
                    <!--<a href="#"> Projects </a>
                    <a href="#"> Tasks </a>
                    <a href="#"> Reporting </a>-->
                    <?php
                    if ($_SESSION['idRol'] != 3) {
                        echo '<a href="Usuarios.php"> Usuarios </a>';
                    }
                    ?>

                </nav>
                <div class="header-navigation-actions">
                    <a class="button">
                        <i class="ph-lightning-bold"></i>
                        <p>Bienvenido <?php echo $_SESSION['nombreUsuario'] ?></p>
                        <span></span>
                    </a>
                    <div class="dropdown">
                        <a href="#" class="avatar">
                            <img src="../img/IconoInicioSesion.png" alt="" />
                        </a>
                        <div class="dropdown-content">
                            <a href="#">Perfil</a>
                            <a href="#">Configuración</a>
                            <a href="../login/cerrar_sesion.php">Cerrar sesión</a>
                        </div>
                    </div>
                </div>
            </div>
            <a href="#" class="button">
                <i class="ph-list-bold"></i>
                <span>Menu</span>
            </a>
        </div>
    </header>
    <main class="main">
        <div class="responsive-wrapper">
            <div class="main-header">
                <h1>Perfil de <?php echo $_SESSION['nombreUsuario'] ?></h1>
            </div>
        </div>
        <div class="responsive-wrapper">
            <form action="actualizar_perfil.php" method="POST">
                <div class="form-group">
                    <label for="nombre_usuario">Nombre de Usuario:</label>
                    <input type="text" id="nombre_usuario" name="nombre_usuario"
                        value="<?php echo $_SESSION['nombreUsuario']; ?>" required>
                </div>
                <div class="form-group">
                    <label for="nomusu">Nombre:</label>
                    <input type="text" id="nomusu" name="nomusu" required value="<?php echo $_SESSION['nombre']; ?>">
                </div>
                <div class="form-group">
                    <label for="nomusu">Apellido:</label>
                    <input type="text" id="apellido" name="nomusu" required
                        value="<?php echo $_SESSION['apellido']; ?>">
                </div>
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" id="email" name="email" required value="<?php echo $_SESSION['email']; ?>">
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono" required
                        value="<?php echo $_SESSION['telefono']; ?>">
                </div>
                <div class="form-group">
                    <label for="contraseña1">Contraseña:</label>
                    <input type="password" id="contraseña1" name="contraseña1" required>
                </div>

                <div class="form-group">
                    <label for="contraseña2">Repite la Contraseña:</label>
                    <input type="password" id="contraseña2" name="contraseña2" oninput="validarContraseña()" required>
                    <span id="mensajeContraseña"></span>
                </div>
                <button type="submit" id="botonActualizar" disabled>Actualizar Perfil</button>
            </form>
    </main>
    <script>
        function validarContraseña() {
            var contraseña1 = document.getElementById("contraseña1").value;
            var contraseña2 = document.getElementById("contraseña2").value;
            var mensaje = document.getElementById("mensajeContraseña");

            if (contraseña1 != contraseña2) {
                mensaje.innerHTML = "Las contraseñas no coinciden.";
                mensaje.style.color = "red";
                boton.disabled = true;
                return false;
            } else {
                mensaje.innerHTML = "Las contraseñas coinciden.";
                mensaje.style.color = "green";
                boton.disabled = false;
                return true;
            }
        }
    </script>
</body>

</html>