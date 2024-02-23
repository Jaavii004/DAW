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

// Paginación
$registros_por_pagina = 10;
$sql = "SELECT COUNT(id) AS total FROM registros";
$result = $conn->query($sql);
$total_registros = $result->fetch_assoc()['total'];
$total_paginas = ceil($total_registros / $registros_por_pagina);

$pagina_actual = isset($_GET['pagina']) ? $_GET['pagina'] : 1;
$inicio = ($pagina_actual - 1) * $registros_por_pagina;

// Obtener registros
$sql = "SELECT * FROM registros ORDER BY id DESC LIMIT $inicio, $registros_por_pagina";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registros de Fichajes</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Registros de Fichajes</h1>
    
    <table>
        <tr>
            <th>Entrada</th>
            <th>Salida</th>
        </tr>
        <?php
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                echo "<tr>
                        <td>".$row["hora_entrada"]."</td>
                        <td>".$row["hora_salida"]."</td>
                    </tr>";
            }
        } else {
            echo "<tr><td colspan='2'>No se encontraron registros</td></tr>";
        }
        ?>
    </table>

    <?php
    // Mostrar paginación
    if ($total_paginas > 1) {
        echo "<div>Páginas:";
        for ($i = 1; $i <= $total_paginas; $i++) {
            if ($i == $pagina_actual) {
                echo " <strong>$i</strong>";
            } else {
                echo " <a href='?pagina=$i'>$i</a>";
            }
        }
        echo "</div>";
    }
    ?>

</body>
</html>

<?php
$conn->close();
?>