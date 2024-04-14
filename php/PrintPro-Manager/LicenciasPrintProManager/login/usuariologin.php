<?php
    session_start();
    if(!isset($_SESSION['nombreUsuario'])){
        echo '
            <script>
            alert("Debes de Iniciar Sesion");
            window.location = "../index.php";
            </script>
        ';
        session_destroy();
        die();
    }
