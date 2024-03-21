CREATE DATABASE reservaVuelos;

USE reservaVuelos;

CREATE TABLE Vuelos (
    id_vuelo INT PRIMARY KEY,
    numero_vuelo VARCHAR(10) NOT NULL,
    origen VARCHAR(50) NOT NULL,
    destino VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    capacidad INT NOT NULL
);

CREATE TABLE Pasajeros (
    id_pasajero INT PRIMARY KEY,
    numero_pasaporte VARCHAR(10) NOT NULL,
    nombre_pasajero VARCHAR(50) NOT NULL
);

CREATE TABLE Vuelos_Pasajeros (
    id_vuelo INT,
    id_pasajero INT,
    n_asiento INT,
    PRIMARY KEY (id_vuelo, id_pasajero),
    FOREIGN KEY (id_vuelo) REFERENCES Vuelos(id_vuelo),
    FOREIGN KEY (id_pasajero) REFERENCES Pasajeros(id_pasajero)
);