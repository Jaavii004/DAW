CREATE DATABASE  IF NOT EXISTS `examen_ev2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `examen_ev2`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: examen_ev2
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `PREGUNTA`
--

DROP TABLE IF EXISTS `PREGUNTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PREGUNTA` (
  `IdPregunta` int NOT NULL AUTO_INCREMENT,
  `Enunciado` varchar(1024) DEFAULT NULL,
  `IdRespuesta` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`IdPregunta`),
  KEY `IdRespuesta` (`IdRespuesta`),
  CONSTRAINT `PREGUNTA_ibfk_1` FOREIGN KEY (`IdRespuesta`) REFERENCES `RESPUESTA` (`IdRespuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PREGUNTA`
--

LOCK TABLES `PREGUNTA` WRITE;
/*!40000 ALTER TABLE `PREGUNTA` DISABLE KEYS */;
INSERT INTO `PREGUNTA` VALUES (1,'Una base de datos es…','1.a'),(2,'El Lenguaje de manipulación de datos permite:','2.a'),(3,'¿Qué representa el puerto de escucha en el modelo cliente-servidor?','3.c'),(4,'Cuando hablamos de integridad de los datos nos referimos a…','4.b'),(5,'¿Cuál de los siguientes sistemas de gestión de bases de datos es software libre?','5.c'),(6,'¿Qué es SQL?','6.c'),(7,'¿Por qué es interesante que el DBMS se encuentre en un servidor?','7.b'),(8,'¿Qué juego de instrucciones de SQL se utiliza para insertar, borrar, modificar y consultar datos?','8.b'),(9,'¿Qué es una base de datos relacional?','9.b'),(10,'¿Cuál de los siguientes elementos no conforma la estructura de datos en una base de datos relacional?','10.c'),(11,'¿Cuál es una característica de los DBMS?',NULL),(12,'¿Qué ventaja tiene una base de datos relacional?','12.b'),(13,'Expón al menos tres argumentos para convencer a un directivo de una empresa, de la conveniencia de que su empresa, que utiliza desde hace años un sistema de ficheros, cambie su enfoque hacia una base de datos.',NULL),(14,'¿Qué quiere decir que un sistema de bases de datos permita concurrencia?',NULL),(15,'Explica los roles del cliente y del servidor en realación a un DBMS que siga el modelo cliente-servidor.',NULL);
/*!40000 ALTER TABLE `PREGUNTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RESPUESTA`
--

DROP TABLE IF EXISTS `RESPUESTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RESPUESTA` (
  `IdRespuesta` varchar(5) NOT NULL,
  `Respuesta` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`IdRespuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESPUESTA`
--

LOCK TABLES `RESPUESTA` WRITE;
/*!40000 ALTER TABLE `RESPUESTA` DISABLE KEYS */;
INSERT INTO `RESPUESTA` VALUES ('1.a','un conjunto de datos estructurados que pertenecen a un mismo contexto y pueden estar relacionados entre sí.'),('1.b','una aplicación software que permite interactuar con los datos, con tareas como la definición, creación, mantenimiento y control de acceso a los datos.'),('1.c','un entorno para la programación de consultas SQL.'),('1.d','un sistema de almacenamiento de datos que permite realizar consultas de forma eficiente.'),('10.a','Relación'),('10.b','Columna'),('10.c','Función'),('10.d','Atributo'),('11.a','Limitar el acceso a los datos.'),('11.b','Facilitar la integridad y persistencia de los datos.'),('11.c','Restringir la eficiencia de las búsquedas.'),('11.d','Ninguna de las anteriores.'),('12.a','Puede almacenar poca información pero de forma muy segura.'),('12.b','Puede almacenar mucha información y relacionarla eficientemente.'),('12.c','Permite definir esquemas dinámicos y flexibles.'),('12.d','Permite manejar grandes volúmenes de datos distribuyendo la carga de trabajo entre múltiples servidores.'),('2.a','Definir la estructura de datos'),('2.b','Definir las relaciones entre los datos'),('2.c','Crear las reglas que han de cumplir los datos'),('2.d','Ninguna de las anteriores.'),('3.a','El hardware utilizado para la comunicación entre el cliente y el servidor.'),('3.b','El protocolo de comunicación utilizado para transmitir datos.'),('3.c','El punto de acceso en el servidor donde se reciben las solicitudes del cliente.'),('3.d','El software instalado en el cliente para acceder a la base de datos.'),('4.a','La capacidad de realizar copias de seguridad periódicas de la base de datos.'),('4.b','La garantía de que la información en la base de datos es precisa, consistente y no está comprometida.'),('4.c','La capacidad de manejar múltiples usuarios accediendo simultáneamente a la base de datos.'),('4.d','La funcionalidad que permite cifrar los datos sensibles almacenados en la base de datos.'),('5.a','Oracle DB'),('5.b','SQL Server'),('5.c','PostgreSQL'),('5.d','Ninguna de las anteriores.'),('6.a','Un lenguaje de programación de bajo nivel.'),('6.b','Un protocolo de comunicación entre servidores.'),('6.c','Un lenguaje de consulta para manipular datos almacenados en una base de datos.'),('6.d','Un sistema operativo para bases de datos.'),('7.a','Porque así se reduce la velocidad de acceso a la base de datos.'),('7.b','Porque permite trabajar con la base de datos desde cualquier lugar.'),('7.c','Porque limita el acceso a la base de datos.'),('7.d','Todas las anteriores.'),('8.a','DDL'),('8.b','DML'),('8.c','DCL'),('8.d','TCL'),('9.a','Aquella que solo permite consultar datos de una tabla.'),('9.b','Aquella que permite relacionar datos de diferentes tablas.'),('9.c','Aquella que no permite almacenar información en tablas.'),('9.d','Aquella que contiene al menos una relación N:M (muchos a muchos).');
/*!40000 ALTER TABLE `RESPUESTA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-06 20:10:34
