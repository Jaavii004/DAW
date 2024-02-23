<?php
// Configurar la conexión a la base de datos (omitido aquí para brevedad)

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET["id"])) {
    $id = $_GET["id"];

    // Actualizar tarea como completada en la base de datos
    $sql = "UPDATE eventos SET completado = 1 WHERE id = $id";

    if ($conn->query($sql) === TRUE) {
        header("Location: index.php"); // Redirigir de vuelta a la página principal
    } else {
        echo "Error al marcar la tarea como completada: " . $conn->error;
    }
}

$conn->close();
?>
