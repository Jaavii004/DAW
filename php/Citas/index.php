<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Citas - Inicio de Sesión</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Sistema de Citas</h1>
        <div class="form-container">
            <h2>Iniciar Sesión</h2>
            <form action="login.php" method="POST">
                <input type="hidden" name="referer" value="<?php echo $_SERVER['REQUEST_URI']; ?>">
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required><br>
                <input type="submit" value="Iniciar Sesión">
            </form>
            <p>¿No tienes una cuenta? <a href="registro.php">Regístrate</a></p>
        </div>
    </div>
</body>
</html>
