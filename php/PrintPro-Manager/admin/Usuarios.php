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
    <title>Usuarios <?php echo namePage; ?></title>
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
                <h1>Usuarios</h1>
                <article class="card derecha">
                    <div class="card-header">
                        <div>
                            <span><img src="../img/actualizar.png" /></span>
                            <h3>Actualizar</h3>
                        </div>
                        <label class="toggle">
                            <input id="autoRefreshToggle" type="checkbox" checked>
                            <span></span>
                        </label>
                    </div>
                </article>
            </div>
            <div class="container">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre Usuario</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Telefono</th>
                            <th>Rol</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php

                        require_once ('../config/config_bd.php');

                        // Consulta para obtener la información de los usuarios
                        $consultaUsuarios = "SELECT Usuarios.id_usuario, Usuarios.nombre_usuario ,Usuarios.nombre AS nomusu, Usuarios.email, Usuarios.telefono , Roles.nombre
                                    FROM Usuarios
                                    JOIN Roles
                                        on Usuarios.id_rol = Roles.id_rol;";

                        // Realizar la consulta a la base de datos
                        $resultadoUsuarios = $conn->query($consultaUsuarios);

                        // Comprobar si hay algún usuario en la base de datos
                        if ($resultadoUsuarios->num_rows > 0) {
                            // Iterar sobre cada fila de resultados y mostrar los usuarios
                            while ($fila = $resultadoUsuarios->fetch_assoc()) {
                                echo "<tr>";
                                echo "<td>" . $fila["id_usuario"] . "</td>";
                                echo "<td>" . $fila["nombre_usuario"] . "</td>";
                                echo "<td>" . $fila["nomusu"] . "</td>";
                                echo "<td>" . $fila["email"] . "</td>";
                                echo "<td>" . $fila["telefono"] . "</td>";
                                echo "<td>" . $fila["nombre"] . "</td>";
                                echo "</tr>";
                            }
                            echo "</tbody>";
                            echo "</table>";
                        } else {
                            // Si no hay usuarios en la base de datos, mostrar un mensaje
                            echo "<p>No se encontraron usuarios.</p>";
                        }
                        ?>

            </div>

        </div>

    </main>
    <script>
        // Función para recargar la página cada minuto
        function autoRefreshPage() {
            setInterval(function () {
                location.reload();
            }, 60000); // 60000 milisegundos = 1 minuto
        }

        // Escucha el cambio en el interruptor
        document.getElementById('autoRefreshToggle').addEventListener('change', function () {
            if (this.checked) {
                autoRefreshPage(); // Si está activado, inicia la actualización automática
            } else {
                clearInterval(autoRefreshPage); // Si está desactivado, detiene la actualización automática
                alert('Actualización automática desactivada'); // Alerta de confirmación
            }
        });
    </script>

</body>

</html>