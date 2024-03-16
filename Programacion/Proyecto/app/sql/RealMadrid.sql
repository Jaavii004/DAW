-- Creación de la tabla Equipos
CREATE TABLE Equipos (
    id_equipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)
);

-- Inserción de equipos
INSERT INTO Equipos (nombre) VALUES
    ('Real Madrid'),
    ('FC Barcelona'),
    ('Atlético de Madrid'),
    ('Sevilla FC');

-- Creación de la tabla Partidos
CREATE TABLE Partidos (
    id_partido INT PRIMARY KEY AUTO_INCREMENT,
    id_equipo_local INT,
    id_equipo_visitante INT,
    fecha DATE,
    resultado VARCHAR(10),
    FOREIGN KEY (id_equipo_local) REFERENCES Equipos(id_equipo),
    FOREIGN KEY (id_equipo_visitante) REFERENCES Equipos(id_equipo)
);

-- Inserción de partidos de ejemplo
INSERT INTO Partidos (id_equipo_local, id_equipo_visitante, fecha, resultado) VALUES
    (1, 2, '2024-03-20', NULL), -- Real Madrid vs FC Barcelona
    (1, 3, '2024-04-05', NULL), -- Real Madrid vs Atlético de Madrid
    (4, 1, '2024-04-20', NULL); -- Sevilla FC vs Real Madrid

-- Creación de la tabla Asientos
CREATE TABLE Asientos (
    id_asiento INT PRIMARY KEY AUTO_INCREMENT,
    id_partido INT,
    zona VARCHAR(50),
    numero INT,
    disponible BOOLEAN,
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido)
);

-- Creación de la tabla Roles
CREATE TABLE Roles (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

-- Inserción de roles
INSERT INTO Roles (nombre) VALUES
    ('superadmin'),
    ('admin'),
    ('usuario');

-- Creación de la tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    email VARCHAR(100),
    contraseña VARCHAR(100),
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);

-- Creación de la tabla Reservas
CREATE TABLE Reservas (
    id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_partido INT,
    id_asiento INT,
    id_usuario INT,
    fecha_reserva DATETIME,
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_asiento) REFERENCES Asientos(id_asiento),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);


-- Crear tabla de Zonas
CREATE TABLE Zonas (
    id_zona INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

-- Insertar datos de zonas
INSERT INTO Zonas (nombre) VALUES
    ('Lateral Este'),
    ('Lateral Oeste'),
    ('Fondo Norte'),
    ('Fondo Sur');

-- Crear tabla de Asientos
CREATE TABLE Asientos (
    id_asiento INT PRIMARY KEY AUTO_INCREMENT,
    id_zona INT,
    numero INT,
    FOREIGN KEY (id_zona) REFERENCES Zonas(id_zona)
);

-- Insertar asientos de ejemplo (para todos los partidos)
INSERT INTO Asientos (id_zona, numero)
SELECT z.id_zona, a.numero
FROM Zonas z
CROSS JOIN (
    SELECT 101 AS numero UNION ALL
    SELECT 102 UNION ALL
    SELECT 201 UNION ALL
    SELECT 202 UNION ALL
    SELECT 301 UNION ALL
    SELECT 302 UNION ALL
    SELECT 401 UNION ALL
    SELECT 402
) a;

-- Crear tabla de Reservas
CREATE TABLE Reservas (
    id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_partido INT,
    id_asiento INT,
    id_usuario INT,
    fecha_reserva DATETIME,
    FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido),
    FOREIGN KEY (id_asiento) REFERENCES Asientos(id_asiento),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);


quiero que cuando le de a entradas me ponga un estadio santiago bernabeu pequeño con cuatro zonas que sean 
    ('Lateral Este'),
    ('Lateral Oeste'),
    ('Fondo Norte'),
    ('Fondo Sur');
y poder dar click sobre una y poder ir a ver a la base de datos los asientos que hay libres para ese partido