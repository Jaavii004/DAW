<?php
// Importar el archivo config.php
require_once '../config/config.php';
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
                        <img src="https://assets.codepen.io/285131/untitled-ui-icon.svg" />
                    </div>
                    <p></p>
                </a>
            </div>
            <div class="header-navigation">
                <nav class="header-navigation-links">
                    <a href="#"> Home </a>
                    <a href="#"> Dashboard </a>
                    <!--<a href="#"> Projects </a>
                    <a href="#"> Tasks </a>
                    <a href="#"> Reporting </a>-->
                    <a href="#"> Users </a>
                </nav>
                <div class="header-navigation-actions">
                    <a href="#" class="button">
                        <i class="ph-lightning-bold"></i>
                        <span></span>
                    </a>

                    <a href="#" class="avatar">
                        <img src="../img/IconoInicioSesion.png" alt="" />
                    </a>
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
                <h1>Incidencias Abiertas</h1>
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
                <!--<div class="search">
                    <input type="text" placeholder="Search" />
                    <button type="submit">
                        <i class="ph-magnifying-glass-bold"></i>
                    </button>
                </div>-->
            </div>
            <div class="container">
                <?php
                // Importar el archivo config.php
                include '../config/config.php';

                // Consulta para obtener la información de los usuarios
                $consultaUsuarios = "SELECT * FROM PrintPro.Usuarios";

                // Realizar la consulta a la base de datos
                $resultadoUsuarios = $conn->query($consultaUsuarios);

                // Comprobar si hay algún usuario en la base de datos
                if ($resultadoUsuarios->num_rows > 0) {
                    // Mostrar una tabla con la información de los usuarios
                    echo "<table>";
                    echo "<thead>";
                    echo "<tr>";
                    echo "<th>ID</th>";
                    echo "<th>Nombre</th>";
                    echo "<th>Email</th>";
                    echo "</tr>";
                    echo "</thead>";
                    echo "<tbody>";
                    // Iterar sobre cada fila de resultados y mostrar los usuarios
                    while ($fila = $resultadoUsuarios->fetch_assoc()) {
                        echo "<tr>";
                        echo "<td>" . $fila["id_usuario"] . "</td>";
                        echo "<td>" . $fila["nombre"] . "</td>";
                        echo "<td>" . $fila["email"] . "</td>";
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