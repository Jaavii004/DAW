CREATE DATABASE IF NOT EXISTS licenciasAdv;
USE licenciasAdv;
CREATE TABLE IF NOT EXISTS licenses (
    clave TEXT PRIMARY KEY,
    valida BOOLEAN
);
