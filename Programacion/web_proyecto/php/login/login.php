<?php
require_once('../config/config_bd.php');

// Crear conexión
$conn = new mysqli($server, $user, $password, $bbdd, $puerto);

// Verificar la conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

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
        header("location: ../bienvenida.php");
    } else {
        echo "Error al actualizar la última sesión: " . $conn->error;
    }
} else {
    echo "Usuario o contraseña incorrectos";
}

$conn->close();
?>
