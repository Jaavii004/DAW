<?php
// Conexión a la base de datos
$servername = "localhost";
$username = "tu_usuario";
$password = "tu_contraseña";
$dbname = "fichajes_db";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Procesar el envío del formulario para fichar
if (isset($_POST['fichar'])) {
    $sql = "INSERT INTO registros (hora_entrada) VALUES (CURRENT_TIMESTAMP)";
    if ($conn->query($sql) === TRUE) {
        echo "<p>Fichado correctamente.</p>";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

// Procesar el envío del formulario para desfichar
if (isset($_POST['desfichar'])) {
    $sql = "UPDATE registros SET hora_salida = CURRENT_TIMESTAMP ORDER BY id DESC LIMIT 1";
    if ($conn->query($sql) === TRUE) {
        echo "<p>Desfichado correctamente.</p>";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control de Fichajes</title>
    <style>
        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            text-decoration: none;
            color: white;
        }
        .green {
            background-color: green;
        }
        .red {
            background-color: red;
        }
    </style>
</head>
<body>
    <h1>Control de Fichajes</h1>
    
    <form method="post">
        <button class="button green" type="submit" name="fichar">Fichar</button>
        <button class="button red" type="submit" name="desfichar">Desfichar</button>
    </form>
</body>
</html>