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
    <title>Incidencias <?php echo namePage; ?></title>
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
            <div class="horizontal-tabs">
                <a href="IncidenciasAbiertas.php" class="active">Incidencias Abiertas</a>
                <a href="Incidencias.php">Todas las incidencias</a>
                <?php
                    if ($_SESSION['idRol'] == 3) {
                        echo '<a href="tecnico.php" >Incidencias Asignadas</a>';
                    }
                ?>
            </div>
        </div>
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

                <table>
                    <thead>
                        <tr>
                            <th>Id incidencia</th>
                            <th>id y modelo Impresora</th>
                            <th>Cliente</th>
                            <th>Problema</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        require_once ('../config/config_bd.php');
                        $InicidenciasAbiertas = "SELECT Incidencias.id_incidencia, Incidencias.id_impresora, Impresoras.modelo, Clientes.nombre, Incidencias.descripcion, Incidencias.f_creacion, Incidencias.contacto
                            FROM Incidencias
                            JOIN Clientes ON Incidencias.id_cliente = Clientes.id_cliente
                            JOIN Impresoras ON Incidencias.id_impresora = Impresoras.id_impresora
                            WHERE Incidencias.estado = 0";

                        $rs = $conn->query($InicidenciasAbiertas);
                        if ($rs->num_rows == 0) {
                            echo "<tr>";
                            echo "<td colspan='5'> No hay incidencias abiertas </td>";
                            echo "</tr>";
                        }
                        foreach ($rs as $row) {
                            echo "<tr>";
                            echo "<td><a class='link-detalles' href='IncidenciaDetallada.php?id=" . $row["id_incidencia"] . "' target='_blank'>" . $row["id_incidencia"] . "</a></td>";

                            echo "<td>" . $row["id_impresora"] . " - " . $row["modelo"] . "</td>";
                            echo "<td>" . $row["nombre"] . "</td>";
                            echo "<td>" . $row["descripcion"] . "</td>";
                            echo "<td>" . $row["f_creacion"] . "</td>";
                            echo "</tr>";
                        }
                        ?>
                    </tbody>
                </table>
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