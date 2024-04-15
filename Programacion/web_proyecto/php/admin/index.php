<?php
// Importar el archivo config.php
include '../config/config.php';
include '../config/config_bd.php';
include '../login/usuariologin.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo namePage; ?></title>
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
                            <a href="PerfilUsu.php">Perfil</a>
                            <?php
                            if ($_SESSION['idRol'] == 1) {
                                echo '<a href="configuracion.php">Configuración</a>';
                            }
                            ?>
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
        <div class="main-content responsive-wrapper">
            <div class="welcome-section" style="background-color: #f2f2f2; text-align: center; padding: 50px;">
                <div class="welcome-message">
                    <h1>Bienvenido, <?php echo $_SESSION['nombreUsuario'] ?>!</h1>
                    <p>Bienvenido al panel de administración de <?php echo namePage; ?></p>
                </div>
            </div>
            <?php if ($_SESSION['idRol'] == 1) { ?>
                <div class="main-header">
                    <h1>Estadisticas</h1>
                </div>
                <div class="card-grid">
                    <article class="card">
                        <div class="card-header">
                            <h3>Incidencias Abiertas</h3>
                        </div>
                        <div class="card-body">
                            <?php
                            $abierta = "SELECT COUNT(estado) AS num FROM Incidencias WHERE estado = 0";
                            $rs = $conn->query($abierta);
                            foreach ($rs as $row) {
                                echo "<p>" . $row["num"] . "</p>";
                            }
                            ?>
                        </div>
                    </article>
                    <article class="card">
                        <div class="card-header">
                            <h3>Incidencias Asignadas</h3>
                        </div>
                        <div class="card-body">
                            <?php
                            $asignadas = "SELECT COUNT(id_tecnico) AS num FROM Incidencias WHERE id_tecnico IS NOT NULL";
                            $rs = $conn->query($asignadas);
                            foreach ($rs as $row) {
                                echo "<p>" . $row["num"] . "</p>";
                            }
                            ?>
                        </div>
                    </article>
                    <article class="card">
                        <div class="card-header">
                            <h3>Incidencias Totales</h3>
                        </div>
                        <div class="card-body">
                            <?php
                            $total = "SELECT COUNT(id_incidencia) AS num FROM Incidencias ";
                            $rs = $conn->query($total);
                            foreach ($rs as $row) {
                                echo "<p>" . $row["num"] . "</p>";
                            }
                            ?>
                        </div>
                    </article>
                </div>
            <?php } ?>
        </div>
    </main>
</body>

</html>