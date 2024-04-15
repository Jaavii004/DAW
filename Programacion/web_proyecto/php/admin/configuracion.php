<?php
// Importar el archivo config.php
include '../config/config.php';
include '../config/config_bd.php';
include '../login/usuariologin.php';
if ($_SESSION['idRol'] != 1) {
    header("Location: index.php");
    exit;
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Configuracion <?php echo namePage; ?></title>
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
                                echo '<a href="Configuracion.php">Configuración</a>';
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
            <div class="main-header">
                <h1>Configuración</h1>
            </div>
            <article class="card small-card">
                <div class="card-header">
                    <h3>Licencia</h3>
                </div>
                <div class="card-body">
                    <p style=" display: inline-block;">Estado: &nbsp;
                    <div class="license-status"></div>Activa</p>
                    <?php
                    $ComprobarLicencia = "SELECT token FROM licencias ORDER BY id DESC LIMIT 1;";
                    $rs = $conn->query($ComprobarLicencia);
                    $row = $rs->fetch_assoc();
                    echo "Licencia: ".$row["token"];
                    ?>

                </div>
            </article>
        </div>
    </main>
</body>

</html>