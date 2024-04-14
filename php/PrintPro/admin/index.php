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
        <div class="main-content responsive-wrapper">
            <div class="welcome-section" style="background-color: #f2f2f2; text-align: center; padding: 50px;">
                <div class="welcome-message">
                    <h1>Bienvenido, <?php echo $_SESSION['nombreUsuario'] ?>!</h1>
                    <p>Bienvenido al panel de administración de <?php echo namePage; ?></p>
                </div>
            </div>
            <div class="card-grid">
                <!-- Tarjeta para incidencias abiertas -->
                <article class="card">
                    <div class="card-header">
                        <h3>Incidencias Abiertas</h3>
                    </div>
                    <div class="card-body">
                        <p>552</p>
                    </div>
                </article>
                <!-- Tarjeta para incidencias asignadas -->
                <article class="card">
                    <div class="card-header">
                    <h3>Incidencias Asignadas</h3>

                    </div>
                    <div class="card-body">
                        <p>105</p>
                    </div>
                </article>
                <article class="card">
                    <div class="card-header">
                        <h3>Incidencias Totales</h3>
                    </div>
                    <div class="card-body">
                        <p>602</p>
                    </div>
                </article>
            </div>
        </div>
    </main>
</body>

</html>