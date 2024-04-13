<?php
require_once('../config/config_bd.php');

$usuario = $_POST['userName'];
$password = $_POST['password'];

$ComprobarLogin = "SELECT * FROM Usuarios WHERE nombre_usuario = '".$usuario."' AND password = MD5('".$password."')";
$rs = $conn->query($ComprobarLogin);

if ($rs->num_rows > 0) {
    $row = $rs->fetch_assoc();
    $idUsuario = $row["id_usuario"];
    $nombreUsuario = $row["nombre_usuario"];
    $nombre = $row["nombre"];
    $apellido = $row["apellido"];
    $email = $row["email"];
    $telefono = $row["telefono"];
    $idRol = $row["id_rol"];
    $ultimoInicioSesion = $row["ultimo_InicioSesion"];
    session_start();
    $_SESSION['idUsuario'] = $idUsuario;
    $_SESSION['nombreUsuario'] = $nombreUsuario;
    $_SESSION['nombre'] = $nombre;
    $_SESSION['apellido'] = $apellido;
    $_SESSION['email'] = $email;
    $_SESSION['telefono'] = $telefono;
    $_SESSION['idRol'] = $idRol;
    $_SESSION['ultimoInicioSesion'] = $ultimoInicioSesion;

    $updateQuery = "UPDATE Usuarios SET ultimo_InicioSesion = CURRENT_TIMESTAMP() WHERE id_usuario = '".$idUsuario."'";
    if ($conn->query($updateQuery) === TRUE) {
        header("location: ../admin/index.php");
    } else {
        echo "Error al actualizar la última sesión: " . $conn->error;
    }
} else {
    session_start();
    // Si las credenciales son incorrectas, mostrar un mensaje de error
    $_SESSION['error'] = "Usuario o contraseña incorrectos.";
    header("Location: ../index.php");
    exit();
}

$conn->close();
?>
