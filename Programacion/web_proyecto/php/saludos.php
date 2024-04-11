<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Saludo PHP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>¡Hola, bienvenido!</h2>
        <p>Por favor, ingresa tu nombre:</p>
        <form method="post">
            <input type="text" name="username" placeholder="Tu nombre" required>
            <input type="submit" value="Enviar">
        </form>
        <?php
        // Verifica si se ha enviado el formulario
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            // Obtiene el nombre de usuario del formulario
            $username = $_POST["username"];
            // Muestra el saludo
            echo "<p>Hola, $username. ¡Bienvenido a nuestra página!</p>";
        }
        ?>
    </div>
</body>
</html>
