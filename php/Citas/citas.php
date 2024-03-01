<?php
session_start();

if (!isset($_SESSION['user_id'])) {
    header("Location: index.php");
    exit();
}

$conn = new mysqli("localhost", "usuario", "contraseña", "basededatos");

if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$user_id = $_SESSION['user_id'];

// Obtener el nombre del usuario
$sql = "SELECT username FROM usuarios WHERE id='$user_id'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $username = $row['username'];
} else {
    $username = "Usuario Desconocido";
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $fecha = $_POST['fecha'];
    $hora_id = $_POST['hora'];

    $sql = "INSERT INTO citas (fecha, hora_id, usuario_id) VALUES ('$fecha', '$hora_id', '$user_id')";

    if ($conn->query($sql) === TRUE) {
        echo "Cita reservada exitosamente.";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

$citas_disponibles = array();

$sql = "SELECT horas.hora FROM horas LEFT JOIN citas ON horas.id = citas.hora_id WHERE citas.fecha = CURDATE() AND citas.hora_id IS NULL";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $citas_disponibles[] = $row['hora'];
    }
}

$conn->close();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Citas - Citas Disponibles</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Sistema de Citas</h1>
        <div class="form-container">
            <h2>Bienvenido, <?php echo $username; ?></h2>
            <h3>Citas Disponibles</h3>
            <form action="" method="POST">
                <label for="fecha">Fecha:</label>
                <input type="date" id="fecha" name="fecha" required><br>
                <label for="hora">Hora:</label>
                <select id="hora" name="hora" required>
                    <?php
                    foreach ($citas_disponibles as $hora) {
                        echo "<option value='$hora'>$hora</option>";
                    }
                    ?>
                </select><br>
                <input type="submit" value="Reservar Cita">
            </form>
            <p><a href="logout.php">Cerrar Sesión</a></p>
        </div>
    </div>
</body>
</html>
