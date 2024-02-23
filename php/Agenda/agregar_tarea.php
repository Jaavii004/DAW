<?php
// Configurar la conexión a la base de datos
$servername = "localhost";
$username = "usuario";
$password = "contraseña";
$database = "agenda";

$conn = new mysqli($servername, $username, $password, $database);

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

// Procesar el formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titulo = $_POST["titulo"];

    // Insertar tarea en la base de datos
    $sql = "INSERT INTO eventos (titulo) VALUES ('$titulo')";

    if ($conn->query($sql) === TRUE) {
        echo "Tarea agregada correctamente.";
    } else {
        echo "Error al agregar la tarea: " . $conn->error;
    }
}

$conn->close();
?>