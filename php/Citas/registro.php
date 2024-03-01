<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Citas - Registro</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Sistema de Citas</h1>
        <div class="form-container">
            <h2>Registrarse</h2>
            <form action="registro.php" method="POST">
                <label for="new_username">Nuevo Usuario:</label>
                <input type="text" id="new_username" name="new_username" required><br>
                <label for="new_password">Nueva Contraseña:</label>
                <input type="password" id="new_password" name="new_password" required><br>
                <input type="submit" value="Registrarse">
            </form>
            <p>¿Ya tienes una cuenta? <a href="index.php">Inicia Sesión</a></p>
        </div>
    </div>
</body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['new_username'];
    $password = $_POST['new_password'];

    // Encriptar la contraseña
    $hashed_password = password_hash($password, PASSWORD_DEFAULT);

    $conn = new mysqli("localhost", "usuario", "contraseña", "basededatos");

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    $sql = "INSERT INTO usuarios (username, password) VALUES ('$username', '$hashed_password')";

    if ($conn->query($sql) === TRUE) {
        echo "Usuario registrado exitosamente.";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();
}
?>
