-- Crear una tabla de usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    edad INT,
    email VARCHAR(100)
);

-- Insertar datos en la tabla de usuarios
INSERT INTO usuarios (id, nombre, edad, email) VALUES
(1, 'Juan', 30, 'juan@example.com'),
(2, 'María', 25, 'maria@example.com'),
(3, 'Pedro', 35, 'pedro@example.com');

-- Seleccionar todos los usuarios
SELECT * FROM usuarios;

-- Seleccionar usuarios mayores de 30 años
SELECT * FROM usuarios WHERE edad > 30;

-- Actualizar el email de un usuario
UPDATE usuarios SET email = 'nuevo_email@example.com' WHERE id = 2;

-- Eliminar un usuario
DELETE FROM usuarios WHERE id = 3;

-- Crear una tabla de productos
CREATE TABLE productos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    stock INT
);

-- Insertar datos en la tabla de productos
INSERT INTO productos (id, nombre, precio, stock) VALUES
(1, 'Camiseta', 20.99, 50),
(2, 'Pantalón', 39.99, 30),
(3, 'Zapatos', 59.99, 20);

-- Seleccionar todos los productos
SELECT * FROM productos;

-- Seleccionar productos con precio superior a 50
SELECT * FROM productos WHERE precio > 50;

-- Actualizar el precio de un producto
UPDATE productos SET precio = 29.99 WHERE id = 1;

-- Añadir stock a un producto
UPDATE productos SET stock = stock + 10 WHERE id = 2;

-- Eliminar un producto
DELETE FROM productos WHERE id = 3;
