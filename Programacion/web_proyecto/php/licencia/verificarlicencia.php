<?php
include '../config/config_bd.php';

$ComprobarLicencia = "SELECT token FROM licencias ORDER BY id DESC LIMIT 1;";
$rs = $conn->query($ComprobarLicencia);

$row = $rs->fetch_assoc();

$token = $row["token"];
if ($token === null) {
    session_start();
    if ($_SESSION['idRol'] == 1) {
        echo '
            <script>
            alert("Licencia Inexistente. Añada una para poder continuar.");
            window.location = "../licencia/añadirlicencia.php";
            </script>
        ';
        exit;
    } else {
        echo '
            <script>
            alert("Licencia Inexistente. Pidele al superadmin que ponga la licencia.");
            window.location = "../";
            </script>
        ';
        exit;
    }
}


$url = "http://192.168.5.8:8787/VerficarLicencia.php?token=" . $token;

$curl = curl_init();

curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

curl_exec($curl);

$respuesta = curl_getinfo($curl, CURLINFO_HTTP_CODE);

curl_close($curl);

if ($respuesta != 200) {
    if ($_SESSION['idRol'] == 1) {
        echo '
            <script>
            alert("Licencia Incorrecta. Añada una para poder continuar.");
            window.location = "../licencia/añadirlicencia.php";
            </script>
        ';
        exit;
    }else{
        echo '
            <script>
            alert("Licencia Incorrecta. Pidele al superadmin que ponga la licencia.");
            window.location = "../";
            </script>
        ';
        exit;
    }
}
