<?php
    require_once('./login/usuariologin.php');
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h1>Bienvenido a   Inicio</h1>
    <p> 
        <?php echo "<p> Bienvenido, " . $_SESSION['nombreUsuario'] . " Con rol ".$_SESSION['idRol']."</p>"; ?>
    </p>
    <a href="./login/cerrar_sesion.php">LogOut</a>
</body>
</html>
