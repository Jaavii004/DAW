CREATE DATABASE IF NOT EXISTS miniAdv;

USE miniAdv;

-- Tabla Clientes
CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    poblacion VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    email VARCHAR(100),
    fecha_registro DATE DEFAULT CURRENT_DATE,
    comentarios TEXT
);
INSERT INTO Clientes (id_cliente, nombre, direccion, poblacion, telefono, email, comentarios) 
VALUES ( 1, 'Deposito de Maquinas', 'Calle Pimpollo 18', 'Beniparrell', 'inventa', 'info.oliplus.es', 'Maquinas nuevas o retiradas');

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
    id_impresora INT AUTO_INCREMENT PRIMARY KEY, -- es igual a ref propia
    id_cliente INT DEFAULT 1, -- Cambiado a id_cliente
    modelo VARCHAR(100),
    numero_serie VARCHAR(50),
    fecha_creacion DATE DEFAULT CURRENT_TIMESTAMP,
    ubicacion VARCHAR(255),
    ultimo_mantenimiento DATE,
    contador_paginas_color INT DEFAULT 0,
    contador_paginas_bn INT DEFAULT 0,
    color BOOLEAN,
    observaciones VARCHAR(255),
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
    ultimo_InicioSesion DATE DEFAULT CURRENT_DATE,
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

-- Tabla Intervenciones
CREATE TABLE Incidencias (
    id_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    id_impresora INT,
    id_cliente INT, -- Cambiado a id_cliente
    id_usuario INT,
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado BOOLEAN,
    contacto VARCHAR(100),
    impreso BOOLEAN DEFAULT FALSE, -- Nuevo campo booleano para indicar si se ha impreso
    FOREIGN KEY (id_impresora) REFERENCES Impresoras(id_impresora),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente), -- Cambiado a id_cliente
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);

-- Tabla Intervenciones
CREATE TABLE Intervenciones (
    id_intervencion INT AUTO_INCREMENT PRIMARY KEY,
    id_incidencia INT,
    id_tecnico INT,
    id_usuario INT, -- Nuevo campo para almacenar el ID del usuario responsable de la intervención
    descripcion TEXT,
    fecha_intervencion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    copias_color INT,
    copias_bn INT,
    FOREIGN KEY (id_incidencia) REFERENCES Incidencias(id_incidencia),
    FOREIGN KEY (id_tecnico) REFERENCES Tecnicos(id_tecnico),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario) -- Relaciona el ID del usuario responsable de la intervención
);

-- Tabla Consumibles
CREATE TABLE Consumibles (
    id_consumible INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    cantidad INT,
    fecha_añadido DATE DEFAULT CURRENT_DATE
);

-- Tabla Intervencion_Consumible
CREATE TABLE Intervencion_Consumible (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_intervencion INT,
    id_consumible INT,
    FOREIGN KEY (id_intervencion) REFERENCES Intervenciones(id_intervencion),
    FOREIGN KEY (id_consumible) REFERENCES Consumibles(id_consumible)
);

-- Tabla Tecnicos
CREATE TABLE Tecnicos (
    id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    telefono VARCHAR(20),
    dni VARCHAR(20)
);




-- Insertar superusuario
INSERT INTO Usuarios (nombre_usuario, nombre, apellido, email, telefono, contraseña, id_rol)
VALUES ('superuser', 'Super', 'Usuario', 'superuser@javier.com', '123456789', MD5('root'), 1);

-- Insertar administrador
INSERT INTO Usuarios (nombre_usuario, nombre, apellido, email, telefono, contraseña, id_rol)
VALUES ('root', 'Admin', 'Root', 'root@javier.com', '123456789', MD5('root'), 2);


-- SELECT Usuarios.nombre_usuario , Usuarios.nombre, Roles.nombre
-- FROM Usuarios
-- JOIN miniAdv.Roles
--     on Usuarios.id_rol = Roles.id_rol;
