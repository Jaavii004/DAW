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
    $_SESSION['nombre'] = $row["nombre"];
    $_SESSION['apellido'] = $row["apellido"];
    $_SESSION['email'] = $row["email"];
    $_SESSION['telefono'] = $row["telefono"];
    $_SESSION['idRol'] = $row["id_rol"];
    require_once('../licencia/verificarlicencia.php');
    $_SESSION['ultimoInicioSesion'] = $row["ultimo_InicioSesion"];
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
