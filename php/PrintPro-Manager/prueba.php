<?php
$token = "8rnpuOulGDb0lxgQsCaLiKmV5BVLll";
$url = "http://localhost/php/LicenciasPrintProManager/VerficarLicencia.php?token=" . $token;

// Inicia una nueva sesión cURL
$curl = curl_init();

// Configura las opciones para la solicitud cURL
curl_setopt($curl, CURLOPT_URL, $url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);

// Realiza la solicitud cURL y obtiene la respuesta
curl_exec($curl);

// Obtiene el código de estado HTTP de la respuesta
$http_code = curl_getinfo($curl, CURLINFO_HTTP_CODE);

// Cierra la sesión cURL
curl_close($curl);

// Imprime el código de estado HTTP y la respuesta
echo "El código de estado HTTP es: " . $http_code . "<br>";
?>
