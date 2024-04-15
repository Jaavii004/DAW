<?php
// Importar el archivo config.php
include '../config/config.php';
include '../login/usuariologin.php';

function generarToken($longitud)
{
    $caracteres = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $longitud_caracteres = strlen($caracteres);
    $token = '';
    for ($i = 0; $i < $longitud; $i++) {
        $token .= $caracteres[rand(0, $longitud_caracteres - 1)];
    }
    return $token;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $descripcion = $_POST['descripcion'];
    $token = generarToken(30);

    require_once ('../config/config_bd.php');
    $sql = "INSERT INTO licencias (token, descripcion) VALUES ('$token', '$descripcion')";
    if ($conn->query($sql) === TRUE) {
        echo '
            <script>
            alert("La licencia se ha creado correctamente.");
            window.location = "Licencias.php";
            </script>
        ';
    } else {
        echo '
            <script>
            alert("Error al crear la licencia.Vuelve a intentarlo);
            window.location = "Licencias.php";
            </script>
        ';
    }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear <?php echo namePage; ?></title>
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
                <a href="Licencias.php">Licencias</a>
                <a href="CrearLicencias.php" class="active">Crear Licencia</a>
            </div>
        </div>
        <div class="responsive-wrapper">
            <div class="main-header">
                <h1>Crear nueva licencia</h1>
            </div>
            <div class="container">
                <form method="post" action="">
                    <label for="descripcion">Descripcion:</label>
                    <input id="text" name="descripcion"></input>
                    <br><br>
                    <button type="submit">Crear</button>
                </form>
            </div>
    </main>
</body>

</html>