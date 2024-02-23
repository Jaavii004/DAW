CREATE DATABASE IF NOT EXISTS fichajes_db;

USE fichajes_db;

CREATE TABLE IF NOT EXISTS registros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hora_entrada TIMESTAMP,
    hora_salida TIMESTAMP
);
