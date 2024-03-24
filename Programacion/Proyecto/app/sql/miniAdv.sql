CREATE DATABASE IF NOT EXISTS miniAdv;

USE miniAdv;

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    email VARCHAR(100),
    poblacion VARCHAR(100),
    fecha_registro DATE,
    comentarios TEXT
);

-- Tabla Contactos
CREATE TABLE Contactos (
    id_contacto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    telefono VARCHAR(20),
    email VARCHAR(100),
    cargo VARCHAR(100), -- Nuevo campo para el cargo en la empresa
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla Impresoras
CREATE TABLE Impresoras (
    id_impresora INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    numero_serie VARCHAR(50),
    fecha_adquisicion DATE,
    ubicacion VARCHAR(255),
    ultimo_mantenimiento DATE,
    contador_paginas INT,
    costo_pagina DECIMAL(10, 2),
    consumibles TEXT,
    estado_tinta_toner VARCHAR(50),
    resolucion_impresion VARCHAR(50),
    capacidad_papel INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20),
    contraseña VARCHAR(100) NOT NULL,
    id_rol INT DEFAULT 3 NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);

-- Tabla Roles
CREATE TABLE Roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Inserción de roles
INSERT INTO Roles (nombre) VALUES
    ('superadmin'),
    ('admin'),
    ('usuario');

-- Tabla Incidencias
CREATE TABLE Incidencias (
    id_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    id_impresora INT,
    id_cliente INT, -- Cambiado a id_cliente
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50),
    FOREIGN KEY (id_impresora) REFERENCES Impresoras(id_impresora),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) -- Cambiado a id_cliente
);

-- Tabla Intervenciones
CREATE TABLE Intervenciones (
    id_intervencion INT AUTO_INCREMENT PRIMARY KEY,
    id_incidencia INT,
    descripcion TEXT,
    fecha_intervencion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_incidencia) REFERENCES Incidencias(id_incidencia)
);
