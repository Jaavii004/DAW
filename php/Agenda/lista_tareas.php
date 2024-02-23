<!DOCTYPE html>
<html>
<head>
    <title>Agenda de tareas</title>
</head>
<body>
    <h2>Lista de Tareas</h2>
    <ul>
        <?php
        // Mostrar todas las tareas de la base de datos
        $conn = new mysqli($servername, $username, $password, $database);
        if ($conn->connect_error) {
            die("Conexión fallida: " . $conn->connect_error);
        }

        $sql = "SELECT * FROM eventos";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $id = $row["id"];
                $titulo = $row["titulo"];
                $completado = $row["completado"] ? "Completada" : "Pendiente";
                echo "<li>$titulo - $completado <a href='marcar_completado.php?id=$id'>Marcar como completada</a></li>";
            }
        } else {
            echo "No hay tareas.";
        }
        $conn->close();
        ?>
    </ul>
</body>
</html>
