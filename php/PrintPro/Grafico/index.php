<?php
// Importar el archivo config.php
include '../config/config_bd.php';
include '../login/usuariologin.php';

// Verificar si el ID de rol es 1
if ($_SESSION['idRol'] == 1) {
    // Establecer la conexión a la base de datos

    // Verificar la conexión
    if (!$conn) {
        die("Falló la conexión a MySQL: " . mysqli_connect_error());
    }

    // Consulta SQL para obtener el número de incidencias abiertas por mes del año actual
    $query = "SELECT MONTH(f_creacion) as mes, COUNT(*) as total FROM Incidencias WHERE YEAR(f_creacion) = YEAR(CURRENT_DATE()) GROUP BY mes";

    // Ejecutar la consulta
    $result = mysqli_query($conn, $query);

    // Verificar si la consulta se ejecutó correctamente
    if (!$result) {
        die("Error al ejecutar la consulta: " . mysqli_error($conn));
    }

    // Inicializar un array para almacenar los datos de incidencias por mes
    $incidencias_por_mes = array_fill(1, 12, 0);

    // Procesar los resultados de la consulta
    while ($row = mysqli_fetch_assoc($result)) {
        $mes = intval($row['mes']);
        $total = intval($row['total']);
        $incidencias_por_mes[$mes] = $total;
    }

    // Convertir el array PHP a formato JSON para pasarlo a JavaScript
    $incidencias_por_mes_json = json_encode(array_values($incidencias_por_mes));
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo namePage; ?></title>
    <!-- Incluir Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>
    <!-- Cuerpo del documento -->
    <?php if ($_SESSION['idRol'] == 1) : ?>
        <!-- Mostrar el gráfico solo si el ID de rol es 1 -->
        <canvas id="grafico-incidencias"></canvas>
        <script>
            // Obtener el contexto del lienzo
            var ctx = document.getElementById('grafico-incidencias').getContext('2d');
            // Crear el gráfico
            var graficoIncidencias = new Chart(ctx, {
                type: 'line', // Cambiar el tipo de gráfico a línea
                data: {
                    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                    datasets: [{
                        label: 'Incidencias Abiertas',
                        data: <?php echo $incidencias_por_mes_json; ?>,
                        backgroundColor: 'rgba(54, 162, 235, 0.5)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    <?php endif; ?>
</body>

</html>
