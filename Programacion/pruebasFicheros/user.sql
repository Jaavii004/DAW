CREATE DATABASE IF NOT EXISTS pruebas;

USE pruebas;

CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    grado VARCHAR(50),
    edad INT
);

select * from Usuarios;