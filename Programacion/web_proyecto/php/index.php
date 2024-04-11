<?php
    // Importar el archivo config.php
    include './config/config.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Login <?php echo namePage; ?></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/style.css">
</head>

<body>
    <div class="wrapper">
        <div class="logo">
            <img src="./img/Logo.png" alt="Logo <?php echo namePage; ?>">
        </div>
        <br>
        <div class="text-center mt-4 name"><?php echo namePage; ?></div>
        <br>
        <form action="./login/login.php" method="post" class="p-3 mt-3">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="userName" id="userName" placeholder="Nombre Usuario">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="Contraseña">
            </div>
            <button class="btn mt-3">Iniciar Sesion</button>
        </form>
        <br>
        <div class="text-center fs-6">
            <a href="#">Forget password?</a>
        </div>
    </div>
</body>

</html>