<?php
    $server = "javier";
    $user = "root";
    $password = "root";
    $bbdd = "LicenciasPrintPro";
    $puerto = 3306;

    // Crear conexión
    $conn = new mysqli($server, $user, $password, $bbdd, $puerto);

    // Verificar la conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }