<?php
require_once('../config/config.php');

// Verificar si se envió el formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtener la licencia del formulario
    $licencia = $_POST['Licencia'];
    session_start();
    // Insertar la licencia en la tabla
    require_once('../config/config_bd.php');
    $sql = "INSERT INTO licencias (token) VALUES ('$licencia')";
    if ($conn->query($sql) === TRUE) {
        session_destroy();
        echo '
            <script>
            alert("Licencia insertada correctamente. Debes volver a iniciar sesion.");
            window.location = "../";
            </script>
        ';
    } else {
        session_destroy();
        echo '
            <script>
            alert("Error al insertar la licencia.Vuelve a intentarlo mas tarde.");
            window.location = "../";
            </script>
        ';
    }
}
