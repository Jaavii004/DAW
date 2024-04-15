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
    <title><?php echo namePage; ?></title>
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="css/styles.css">
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
                    <a href="Licencias.php"> Licencias </a>
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
            <div class="horizontal-tabs">
                <a href="Licencias.php" class="active">Licencias</a>
                <a href="CrearLicencias.php">Crear Licencia</a>
            </div>
        </div>
        <div class="responsive-wrapper">
            <div class="main-header">
                <h1>Todas las Licencias</h1>
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
                            <th>Id</th>
                            <th>Token</th>
                            <th>Descripcion</th>
                            <th>Estado</th>
                            <th>Cambiar Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        require_once ('../config/config_bd.php');
                        $TodasLicencias = "SELECT id, token, descripcion, estado FROM licencias ORDER BY id DESC;";

                        $rs = $conn->query($TodasLicencias);
                        if ($rs->num_rows == 0) {
                            echo "<tr>";
                            echo "<td colspan='4'> No hay Licencias actualmente </td>";
                            echo "</tr>";
                        }
                        foreach ($rs as $row) {
                            echo "<tr>";
                            echo "<td>" . $row["id"] . "</td>";
                            echo "<td>" . $row["token"] . "</td>";
                            echo "<td>" . $row["descripcion"] . "</td>";
                            $estado_Licencia = ($row["estado"] == 0) ? "Desactivada" : "Activada";
                            echo "<td>" . $estado_Licencia . "</td>";
                            echo "<td>";
                            echo "<a href='Cambiarestado.php?id=" . $row["id"] . "&estado=" . $row["estado"] . "' class='button' >";
                            echo ($row["estado"] == 0) ? "Activar" : "Desactivar";
                            echo "</a>";
                            echo "</tr>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>

        </div>

    </main>
    <script>
        let intervalId; // Variable global para almacenar el ID del intervalo

        function autoRefreshPage() {
            intervalId = setInterval(function () {
                location.reload();
            }, 60000); // 60000 milisegundos = 1 minuto
        }

        document.getElementById('autoRefreshToggle').addEventListener('change', function () {
            if (this.checked) {
                autoRefreshPage();
            } else {
                clearInterval(intervalId); // Detener el intervalo utilizando el ID almacenado
            }
        });

    </script>

</body>

</html>