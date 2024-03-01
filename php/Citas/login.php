<?php
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $conn = new mysqli("localhost", "usuario", "contraseña", "basededatos");

    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }

    $sql = "SELECT id, password FROM usuarios WHERE username='$username'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $hashed_password = $row['password'];
        if (password_verify($password, $hashed_password)) {
            $_SESSION['user_id'] = $row['id'];
            if(isset($_POST['referer'])) {
                header("Location: ".$_POST['referer']);
            } else {
                header("Location: citas.php");
            }
            exit();
        } else {
            $error_message = "Nombre de usuario o contraseña incorrectos.";
        }
    } else {
        $error_message = "Nombre de usuario o contraseña incorrectos.";
    }

    $conn->close();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error de Inicio de Sesión</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Error de Inicio de Sesión</h1>
        <div class="form-container">
            <p><?php echo $error_message; ?></p>
            <a href="index.php">Volver al Inicio</a>
        </div>
    </div>
</body>
</html>
