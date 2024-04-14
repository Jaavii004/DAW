<?php
require_once 'config/config_bd.php';

if (isset($_GET['token'])) {
    // Recoger el token de la licencia desde la solicitud y escaparlo para evitar inyección de SQL
    $token = $_GET['token'];

    // Consulta para verificar si la licencia existe y está activa
    $verficarlicencia = "SELECT COUNT(*) as count FROM licencias WHERE token = '$token' AND estado = 1";
    $rs = $conn->query($verficarlicencia);

    // Obtener el resultado de la consulta
    $row = $rs->fetch_assoc();

    // Devolver el código de estado HTTP correspondiente
    if ($row['count'] > 0) {
        http_response_code(200); // OK
        exit;
    }
}
http_response_code(404); // Not Found
?>
