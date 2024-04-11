<?php
require_once('./config/config_bd.php');

// Crear conexión
$conn = new mysqli($server, $user, $password, $bbdd);

// Verificar la conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$usuario = $_POST['usuario'];
$password = $_POST['password'];

$ComprobarLogin = "SELECT * FROM Usuarios WHERE nombre_usuario = '".$usuario."' AND password = MD5('".$password."')";
$rs = $conn->query($ComprobarLogin);

if ($rs->num_rows > 0) {
    $row = $rs->fetch_assoc();
    $idUsuario = $row["id_usuario"];
    // Aquí deberías hacer lo que necesites con el usuario validado
    $updateQuery = "UPDATE Usuarios SET ultimo_InicioSesion = CURRENT_TIMESTAMP WHERE id_usuario = '".$idUsuario."'";
    if ($conn->query($updateQuery) === TRUE) {
        echo "Inicio de sesión exitoso";
    } else {
        echo "Error al actualizar la última sesión: " . $conn->error;
    }
} else {
    echo "Usuario o contraseña incorrectos";
}

$conn->close();
?>
