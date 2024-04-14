<?php
session_start();

// Lógica para actualizar el perfil y validar la contraseña
// Supongamos que $exito es una variable que indica si la operación fue exitosa
$exito = true; // Esto es solo un ejemplo, debes ajustarlo según tu lógica de negocio

if ($exito) {
    $_SESSION['mensaje'] = "Perfil actualizado correctamente.";
} else {
    $_SESSION['mensaje'] = "Hubo un error al actualizar el perfil.";
}

// Redireccionar de vuelta al formulario
header("Location: formulario.php");
exit();
?>
