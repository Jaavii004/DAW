<?php
require_once('../config/config.php');
?>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Incidencias <?php echo namePage; ?></title>
    <?php echo rutaico; ?>
    <link rel="stylesheet" href="../admin/styles.css">
</head>

<body>
    <main class="main">
        <div class="responsive-wrapper">
            <form action="./licencia.php" method="post">
                <center>
                    <div class="mt-4 name">Licenciar <?php echo namePage; ?></div>
                </center>
                <div class="form-group">
                    <input type="text" name="Licencia" id="Licencia" minlength="30" maxlength="30" required>
                </div>
                <button type="supmit">Licenciar <?php echo namePage; ?></button>
            </form>
        </div>

    </main>
</body>

</html>