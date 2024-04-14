<?php
require_once('../config/config_bd.php');

$usuario = $_POST['userName'];
$password = $_POST['password'];

$ComprobarLogin = "SELECT * FROM Usuarios WHERE nombre_usuario = '".$usuario."' AND password = MD5('".$password."')";
$rs = $conn->query($ComprobarLogin);

if ($rs->num_rows > 0) {
    $row = $rs->fetch_assoc();
    session_start();
    $_SESSION['idUsuario'] = $row["id_usuario"];
    $_SESSION['nombreUsuario'] = $row["nombre_usuario"];
    header("location: ../admin/");
} else {
    session_start();
    // Si las credenciales son incorrectas, mostrar un mensaje de error
    $_SESSION['error'] = "Usuario o contraseña incorrectos.";
    header("Location: ../index.php");
}

$conn->close();
?>
