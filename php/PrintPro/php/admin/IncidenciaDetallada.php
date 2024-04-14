<?php
// Importar el archivo config.php
include '../config/config.php';
include '../login/usuariologin.php';
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SuperAdmin <?php echo namePage; ?></title>
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <header class="header">
        <div class="header-content responsive-wrapper">
            <div class="header-logo">
                <a href="#">
                    <div>
                        <img src="../img/Logo.png" class="logo-img" />
                    </div>
                    <p></p>
                </a>
            </div>
            <div class="header-navigation">
                <nav class="header-navigation-links">
                    <a href="index.php"> Home </a>
                    <a href="IncidenciasAbiertas.php"> Incidencias </a>
                    <?php
                    if ($_SESSION['idRol'] != 3) {
                        echo '<a href="Usuarios.php"> Usuarios </a>';
                    }
                    ?>

                </nav>
                <div class="header-navigation-actions">
                    <a class="button">
                        <i class="ph-lightning-bold"></i>
                        <p>Bienvenido <?php echo $_SESSION['nombreUsuario'] ?></p>
                        <span></span>
                    </a>
                    <div class="dropdown">
                        <a href="#" class="avatar">
                            <img src="../img/IconoInicioSesion.png" alt="" />
                        </a>
                        <div class="dropdown-content">
                            <a href="#">Perfil</a>
                            <a href="#">Configuración</a>
                            <a href="../login/cerrar_sesion.php">Cerrar sesión</a>
                        </div>
                    </div>
                </div>
            </div>
            <a href="#" class="button">
                <i class="ph-list-bold"></i>
                <span>Menu</span>
            </a>
        </div>
    </header>
    <main class="main">
        <div class="responsive-wrapper">
            <div class="horizontal-tabs">
                <a href="IncidenciasAbiertas.php">Incidencias Abiertas</a>
                <a href="Incidencias.php">Todas las incidencias</a>
            </div>
        </div>
        <div class="responsive-wrapper">
            <div class="main-header">
                <h1>Incidencias Detallada <?php echo $_GET['id']; ?></h1>
            </div>
            <div class="container">
                <?php
                require_once ('../config/config_bd.php');

                // Obtener el ID de la incidencia de la U0RL
                $incidencia_id = $_GET['id'];

                // Consulta para obtener la información de la incidencia, la impresora y el cliente
                $consulta = "SELECT Incidencias.id_incidencia, Incidencias.descripcion, Incidencias.f_creacion, Incidencias.contacto, Incidencias.estado, 
                                        Impresoras.id_impresora ,Impresoras.modelo, Impresoras.numero_serie, Impresoras.ubicacion, Impresoras.observaciones, Impresoras.color,
                                        Clientes.nombre , Clientes.poblacion, Clientes.direccion, Clientes.telefono, Clientes.email, Clientes.comentarios
                                        FROM Incidencias
                                        JOIN Clientes ON Incidencias.id_cliente = Clientes.id_cliente
                                        JOIN Impresoras ON Incidencias.id_impresora = Impresoras.id_impresora
                                        WHERE Incidencias.id_incidencia = $incidencia_id";

                $rs = $conn->query($consulta);

                if ($rs->num_rows == 0) {
                    echo "<p>No se pudo obtener información de esa incidencia.</p>";
                } else {
                    $row = $rs->fetch_assoc();
                    // Comprobar el estado de la incidencia
                    $estado_incidencia = ($row["estado"] == 0) ? "Abierta" : "Cerrada";
                    ?>

                    <h2>Detalles de la incidencia</h2>
                    <table>
                        <tr>
                            <th>ID de la incidencia</th>
                            <td><?php echo $row["id_incidencia"]; ?></td>
                        </tr>
                        <tr>
                            <th>Descripción</th>
                            <td><?php echo $row["descripcion"]; ?></td>
                        </tr>
                        <tr>
                            <th>Fecha de creación</th>
                            <td><?php echo $row["f_creacion"]; ?></td>
                        </tr>
                        <tr>
                            <th>Contacto</th>
                            <td><?php echo $row["contacto"]; ?></td>
                        </tr>
                        <tr>
                            <th>Estado de la incidencia</th>
                            <td><?php echo $estado_incidencia; ?></td>
                        </tr>
                    </table>


                    <h2>Detalles de la impresora</h2>
                    <table>
                        <tr>
                            <th>Id Impresora</th>
                            <td><?php echo $row["id_impresora"]; ?></td>
                        </tr>
                        <tr>
                            <th>Modelo</th>
                            <td><?php echo $row["modelo"]; ?></td>
                        </tr>
                        <tr>
                            <th>Número de serie</th>
                            <td><?php echo $row["numero_serie"]; ?></td>
                        </tr>
                        <tr>
                            <th>Ubicación</th>
                            <td><?php echo $row["ubicacion"]; ?></td>
                        </tr>
                        <tr>
                            <th>Color</th>
                            <td><?php echo ($row["color"] == 1) ? "Color" : "Blanco y negro"; ?></td>
                        </tr>
                        <tr>
                            <th>Observaciones</th>
                            <td><?php echo $row["observaciones"]; ?></td>
                        </tr>
                    </table>

                    <h2>Detalles del cliente</h2>
                    <table>
                        <tr>
                            <th>Nombre</th>
                            <td><?php echo $row["nombre"]; ?></td>
                        </tr>
                        <tr>
                            <th>Población</th>
                            <td><?php echo $row["poblacion"]; ?></td>
                        </tr>
                        <tr>
                            <th>Dirección</th>
                            <td><?php echo $row["direccion"]; ?></td>
                        </tr>
                        <tr>
                            <th>Teléfono</th>
                            <td><?php echo $row["telefono"]; ?></td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td><?php echo $row["email"]; ?></td>
                        </tr>

                        <tr>
                            <th>comentarios</th>
                            <td><?php echo $row["comentarios"]; ?></td>
                        </tr>
                    </table>
                    <?php
                }
                ?>

            </div>
        </div>
    </main>
</body>

</html>