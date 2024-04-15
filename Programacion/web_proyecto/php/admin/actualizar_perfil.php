<?php
include '../login/usuariologin.php';
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = $_POST['nomusu'];
    $apellido = $_POST['apellido'];
    $email = $_POST['email'];
    $telefono = $_POST['telefono'];
    $contraseña = $_POST['contraseña1'];
    $id = $_SESSION['id_usuario'];

    include '../config/config_bd.php';
    $update = "UPDATE Usuarios SET nombre = '$nombre', apellido = '$apellido', email = '$email', telefono = '$telefono', password = '$contraseña' WHERE id_usuario = '$id' ;";

    $rs = $conn->query($update);

    if ($rs === true) {
        $_SESSION['nombre'] = $_POST['nomusu'];
        $_SESSION['apellido'] = $_POST['apellido'];
        $_SESSION['email'] = $_POST['email'];
        $_SESSION['telefono'] = $_POST['telefono'];
        $_SESSION['contraseña'] = $_POST['contraseña1'];
        $id = $_SESSION['id_usuario'];

        echo '
            <script>
            alert("Actualizado correctamente.");
            window.location = "PerfilUsu.php";
            </script>
        ';
    } else {
        echo '
            <script>
            alert("error.");
            window.location = "PerfilUsu.php";
            </script>
        ';
    }
}
?>