<?php
    $server = "192.168.5.8";
    $user = "root";
    $password = "dbrootpass";
    $bbdd = "LicenciasPrintPro";
    $puerto = 33006;

    // Crear conexión
    $conn = new mysqli($server, $user, $password, $bbdd, $puerto);

    // Verificar la conexión
    if ($conn->connect_error) {
        die("Conexión fallida: " . $conn->connect_error);
    }