CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS citas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    hora_id INT,
    usuario_id INT,
    FOREIGN KEY (hora_id) REFERENCES horas(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE IF NOT EXISTS horas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hora TIME
);
