CREATE DATABASE IF NOT EXISTS LicenciasPrintPro;

USE LicenciasPrintPro;

CREATE TABLE `Usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
);

-- Inserta un usuario con contraseña encriptada en MD5
INSERT INTO Usuarios (nombre_usuario, password)
VALUES ('admin', MD5('admin'));
INSERT INTO Usuarios (nombre_usuario, password)
VALUES ('root', MD5('root'));


CREATE TABLE IF NOT EXISTS licencias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  token VARCHAR(255) NOT NULL,
  descripcion TEXT
);

-- Modificar la tabla licencias para agregar un campo de estado
ALTER TABLE licencias
ADD COLUMN estado BOOLEAN NOT NULL DEFAULT TRUE;