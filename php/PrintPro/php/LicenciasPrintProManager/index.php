<?php
// Importar el archivo config.php
include './config/config.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login <?php echo namePage; ?></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
    <main class="main">
        <div class="responsive-wrapper">
            <form action="./login/login.php" method="post">
                <div class="mt-4 name"><?php echo namePage; ?></div>
                <br>
                <div class="form-group">
                    <label for="Usuario">Usuario:</label>
                    <input type="text" name="userName" id="userName" required>
                </div>

                <div class="form-group">
                    <label for="contraseña">Contraseña:</label>
                    <input type="password" name="password" id="pwd" required>
                </div>
                <button type="supmit">Iniciar Sesión</button>
            </form>
        </div>

    </main>
</body>

</html>