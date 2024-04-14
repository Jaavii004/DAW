<?php
if(isset($_GET['id']) && isset($_GET['estado'])) {
    $id = $_GET['id'];
    $estado_actual = $_GET['estado'];
    
    // Ponemos el estado al contrario para poder cambiar el estado
    $nuevo_estado = ($estado_actual == 0) ? 1 : 0;

    require_once ('../config/config_bd.php');
    $sql = "UPDATE licencias SET estado = $nuevo_estado WHERE id = $id";
    if ($conn->query($sql) === TRUE) {
        header("Location: Licencias.php");
        exit();
    } else {
        echo "Error al actualizar el estado de la licencia: " . $conn->error;
    }

    $conn->close();
}
?>
