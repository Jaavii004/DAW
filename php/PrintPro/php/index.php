<?php
// Importar el archivo config.php
include './config/config.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Login <?php echo namePage; ?></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>
    <div class="wrapper">
        <div class="logo">
            <img src="./img/Logo.png" alt="Logo <?php echo namePage; ?>">
        </div>
        <br>
        <div class="mt-4 name"><?php echo namePage; ?></div>
        <br>
        <form action="./login/login.php" method="post" class="p-3 mt-3">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="userName" id="userName" placeholder="Nombre Usuario" required>
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="Contraseña" required>
            </div>
            <button class="btn mt-3">Iniciar Sesión</button>
        </form>
        <div class="fs-6">
            <?php
            echo "<p class='error-message'>Error en el inicio de sesion</p>";

            ?>
        </div>
    </div>
</body>

</html>